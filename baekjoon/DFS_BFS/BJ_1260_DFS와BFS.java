
/*
 * Collections로 풀기
https://developer-mac.tistory.com/63
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {

	static int N, M, V, node1, node2;
	static ArrayList<Integer>[] list;
	static Queue<Integer> queue;
	static boolean[] visited;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		/* line 27~44: 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			list[node2].add(node1);
		}
		
		/* 순회를 위해 list 배열 요소 정렬 */
		for(int i = 1; i <= N; i++)
			Collections.sort(list[i]);
		
		/* 깊이 우선 탐색 */
		visited = new boolean[N+1];
		dfs(V);
		sb.setLength(sb.length()-1);
		sb.append("\n");
		
		/* 너비 우선 탐색 */
		visited = new boolean[N+1];
		bfs(V);
		sb.setLength(sb.length()-1);
		
		/* 결과 출력 */
		System.out.print(sb);	
	}
	
	/* dfs: 재귀 */
	private static void dfs(int v) {
		// 방문한 노드면 이전 노드로 돌아가기
		if(visited[v]) return;
		
		visited[v] = true;		// 방문 표시
		sb.append(v + " ");		// 방문 노드 문자열에 추가
		
		for(int l : list[v]) {	// 방문 노드에서 갈 수 있는 자식 노드가 있을 동안
			if(visited[l]) continue;	// 방문했던 노드라면 다음 요소 판단
			dfs(l);				// 자식 요소가 방문하지 않았던 노드라면 이동하여 다시 탐색
		}
	}
	
	/* bfs: 반복 */
	private static void bfs(int v) {
		queue = new LinkedList<Integer>();	// 노드 저장 큐 생성
		queue.add(v);						// 현재 노드 큐에 넣기
		visited[v] = true;					// 방문 포시
		
		while(!queue.isEmpty()) {			// 현재 노드에서 갈 수 있는 노드가 있을 동안
			int tmp = queue.poll();			// 현재 노드 임시 저장
			sb.append(tmp + " ");			// 방문 노드 문자열에 추가
			for(int l : list[tmp]) {		// 형재 노드가 있을 동안
				if(visited[l]) continue;	// 방문했던 노드라면 다음 요소 판단
				visited[l] = true;			// 방문 표시
				queue.add(l);				// 다음 노드 큐에 추가
			}
		}
	}
}
