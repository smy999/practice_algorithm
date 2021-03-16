package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_1238_Contact {
	
	static int N, start, max, depth;
	static ArrayList[] nodes;
	static boolean[] visited;
	static Queue<int[]> queue = new LinkedList<>();
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			nodes = new ArrayList[N+1];
			visited = new boolean[N+1];
			
			for(int i = 1; i <= N; i++)
				nodes[i] = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodes[from].add(to);
			}
			
			queue.add(new int[] {start, 0});
			visited[start] = true;
			max = 0; depth = 0;
			while(!queue.isEmpty()) {
				
				int[] temp = queue.poll();
				if(depth < temp[1]) {
					depth = temp[1]; max = temp[0];
				} else {
					max = Math.max(max, temp[0]);
				}
				
				for(int i = 0; i < nodes[temp[0]].size(); i++) {
					int temp2 = (int)nodes[temp[0]].get(i);
					if(visited[temp2]) continue;
					visited[temp2] = true;
					queue.add(new int[] {temp2, temp[1]+1});
				}
			}
			queue.clear();
			System.out.println("#" + t + " "+ max);
		}
		
	}
}
