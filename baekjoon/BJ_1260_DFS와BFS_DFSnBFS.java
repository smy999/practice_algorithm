package Feb_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_1260_DFS와BFS {

	static int N, M, V;
	static boolean flag;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 정점 정보 저장 리스트 자료구조
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		// 정점 + 간선 정보 입력 (양방향)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		// 정점과 연결된 정점 순서 정렬
		for(int i = 1; i <= N; i++) Collections.sort(list[i]);
		
		// 결과 저장 문자열
		sb = new StringBuilder();
		
		// dfs
		visited = new boolean[N+1];
		dfs(V, 1);
		
		sb.append("\n");
		
		// bfs
		visited = new boolean[N+1];
		bfs();
		
		System.out.print(sb);
	}
	
	public static void dfs(int idx, int cnt) {
		if(flag) return;	// 정답을 찾은 이후 가지치기
		
		if(cnt == N) {		// 정답을 찾았을 때
			sb.append(idx).append(" ");
			flag = true;
			return;
		}
		
		// 방문하기
		sb.append(idx).append(" ");
		visited[idx] = true;
		
		// 다음 방문지 정하기
		for(int i = 0; i < list[idx].size(); i++) {
			int next = list[idx].get(i);
			if(visited[next]) continue;
			dfs(next, cnt+1);
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			// 방문하기
			int cur = queue.poll();
			sb.append(cur).append(" ");
			
			// 다음 방문지 정하기
			for(int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(visited[next]) continue;
				visited[next] = true;
				queue.add(next);
			}
		}
	}
}
