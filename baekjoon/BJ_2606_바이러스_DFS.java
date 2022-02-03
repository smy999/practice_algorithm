package Feb_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_2606_바이러스_DFS {

	static int N, E, cnt;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		visited = new boolean[N+1];
		
		dfs(1);
		
		// 주의: 바이러스에 감염된 컴퓨터의 수가 아니라 1번 컴퓨터를 통해 바이러스에 걸리는 컴퓨터의 수
		System.out.print(cnt-1); 
	}
	
	public static void dfs(int n) {
		visited[n] = true;
		cnt++;
		
		for(int i : list[n]) {
			if(visited[i]) continue;
			dfs(i);
		}
	}
}
