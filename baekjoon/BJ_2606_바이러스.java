

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_2606_바이러스 {

	static int N, P, cnt;
	static int[][] computers;
	static ArrayList<Integer>[] computer;
	static Queue<Integer> queue;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		computer = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++)
			computer[i] = new ArrayList<Integer>();
		
		int c1, c2;
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			computer[c1].add(c2);
			computer[c2].add(c1);
		}
		
		bfs(1);
		
		System.out.println(cnt);
	}
	
	private static void bfs(int i) {
		
		queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for(int c : computer[tmp]) {
				if(visited[c]) continue;
				
				// 주의: 1로 인해 감염된 컴퓨터의 수이므로 1은 포함되지 않는다.
				cnt++;
				visited[c] = true;
				queue.add(c);
			}
		}
	}
}
