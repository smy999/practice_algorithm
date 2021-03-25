import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_1219_길찾기 {
	
	static int N;
	static ArrayList[] nodes;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t = 1; t <= 10 ; t++) {
			
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			N = Integer.parseInt(st.nextToken());
			nodes = new ArrayList[100];
			visited = new boolean[100];
			for(int i = 0; i < 100; i++)
				nodes[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				nodes[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			
			queue.add(0);
			visited[0] = true;
			
			if(bfs()) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);
		}
	}
	
	private static boolean bfs() {
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int i = 0; i < nodes[node].size(); i++) {
				int next = (int)nodes[node].get(i);
				if(next == 99) return true;
				if(visited[next]) continue;
				visited[next] = true;
				queue.add(next);
			}
		}
		
		return false;
		
	}
}


//출력: 길이 있으면 1, 없으면 0
