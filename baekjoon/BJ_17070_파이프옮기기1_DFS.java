import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1_DFS {

	static int N, cnt;
	static int[][] map;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dfs 탐색 시작
		dfs(0, 1, 0);
		
		System.out.print(cnt);
	}
	
	// delta 0: 가로, 1: 대각선, 2: 세로
	// pipe 0: 가로, 1: 대각선, 2: 세로
	private static void dfs(int r, int c, int pipe) {
		// 기저조건
		if(r == N-1 && c == N-1) {
			// 마지막 노드에 도학하면 경우의 수 증가
			cnt++;
			return;
		}
		
		for(int d = 0; d < 3; d++) {
			// 가로, 세로 제약사항 거르기
			if((pipe == 0 && d == 2) || (pipe == 2 && d == 0)) continue;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 및 벽 확인
			if(nr >= N || nc >= N || map[nr][nc] == 1) continue;
			
			// 오류 원인: d==1가 아닌, pipe==1로 비교함.
			// 현재 방향이 아니라 가려는 방향을 고려해야 한다.
			if(d == 1 && (map[nr-1][nc] == 1 || map[nr][nc-1] == 1)) continue;
			
			dfs(nr, nc, d);
		}

	}
}
