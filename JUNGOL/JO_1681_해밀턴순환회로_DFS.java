package hwalgo18_서울_13반_서민영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// line 15~29: 선언 및 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 입력 크기
		
		map = new int[N][N];					// 입력 배열
		visited = new boolean[N];				// 방문 배열
		
		for(int i = 0; i < N; i++) {			// 입력 배열 저장
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true;		// 출발점(0) 방문 표시
		dfs(0, 0, 0);			// 탐색 시작(매개변수: 노드 번호, 거리, 방문 개수)
		
		// 결과 출력
		System.out.print(min);
	}
	
	/* dfs & backtracking */
	private static void dfs(int start, int dist, int cnt) {
		// 모든 정점을 방문했을 때
		if(cnt == N-1) {
			if(map[start][0] == 0) return;				// 다시 출발점으로 돌아와야하는데, 값이 0이면 실패 > return
			min = Math.min(min, dist+map[start][0]);	// 최소거리 갱신
			return;
		}
		
		// 가지치기
		if(min <= dist) return;		
		
		// 방문 표시
		visited[start] = true;		
		
		// 현재 노드에서 갈 수 있는 모든 정점을 방문한다.
		for(int i = 0; i < N; i++) {
			if(visited[i] || map[start][i] == 0) continue;	// 방문 기록이 있거나, 갈 수 없는 노드이면 다음 노드 탐색
			dfs(i, dist+map[start][i], cnt+1);				// 갈 수 있는 노드 바운
			visited[i] = false;								// 되돌아오며 방문 기록 취소
		}
	}
}
