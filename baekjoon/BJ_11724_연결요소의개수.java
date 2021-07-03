package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11724_연결요소의개수 {

	static int N, M;	// 노드 개수, 입력 개수
	static int[][] adjMatrix;	// 인접행렬
	static boolean[] visited;	// 방문배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjMatrix = new int[N+1][N+1];
		visited = new boolean[N+1];		// 방문배열의 개수는 노드의 수만큼: 해당 노드를 방문했는지를 확인하기 떄문에
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjMatrix[start][end] = adjMatrix[end][start] = 1;
		}
		
		int cnt = 0;	// 결과 이어진 개수
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {	// 방문한 적이 없는 노드만 방문
				dfs(i);			// 한번실행하면 인접한거 다찾아
				cnt++;			// 인전한 개수 증가
			}
		}
		
		System.out.print(cnt);
	}
	
	public static void dfs(int no) {
		if(visited[no]) return;	// 방문한 적이 있으면 더이상 구할필요 없어
		
		visited[no] = true;	// 방문했다고 표시
		
		for(int i = 1; i <= N; i++) {
			if(adjMatrix[no][i] == 1) dfs(i);	// 연결된 상태일때 해당 노드로 이동해서 계속 탐색
		}
	}
}
