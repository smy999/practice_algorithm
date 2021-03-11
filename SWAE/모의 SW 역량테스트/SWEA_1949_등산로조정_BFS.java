package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조정 {

	static int N, K, max, highest;
	static boolean cut;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			max = 0;
			highest = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (highest < map[i][j])
						highest = map[i][j]; // 가장 높은 봉우리 높이 h를 찾는다.
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (highest == map[i][j]) { // 높이가 h인 모든 칸에서 시작해본다.
						cut = false;
						dfs(i, j, 1);
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}

	// i, j : 좌표, k: 남은 깜음 횟수, s: 이전 등산로 길이
	private static void dfs(int i, int j, int len) {
		// 방문 표시
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) { // 현재칸에서 인접한 낮은 칸으로 이동한다.
			int nr = i + dr[d];
			int nc = j + dc[d];

			// 범위를 벗어나거나 방문했던 곳이면 다음 방향 탐색
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
				continue;

			// 다음 산이 현재 산보다 낮으면 이동
			if(map[nr][nc] < map[i][j]){
				dfs(nr, nc, len + 1);	
			}
			else {
				// 높이 차이가 k보다 작고 깎는 회수가 남아있으면 이동한다.
				if (!cut && (map[nr][nc] - K < map[i][j])) {
					cut = true;				// 깎음 표시
					int tmp = map[nr][nc];	// 깎기 전 값 임시저장
					map[nr][nc] = map[i][j] - 1;	// 깎기
					dfs(nr, nc, len + 1);	// 다음 이동
					map[nr][nc] = tmp;		// 되돌아왔으니 원래 값 저장
					cut = false;			// 되돌아왔으니 깎음 표시 제거
				}
			}

		}
		max = Math.max(max, len);	// 최대 길이 갱신
		visited[i][j] = false;		// 방문 표시 제거
	}
}
