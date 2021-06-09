package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고: https://dlwnsdud205.tistory.com/29

public class BJ_1113_수영장만들기 {

	static int N, M, maxH = 0;
	static int[][] land, water;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 땅 크기 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 땅 정보 입력
		land = new int[N][M];
		for(int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				land[i][j] = temp[j] - '0';
				if(land[i][j] == 0) continue;
				maxH = Math.max(maxH, land[i][j]);
			}
		}
		
		// 일단 범위와 벽을 신경쓰지 않고 칸에 채울 수 있는 물을 모두 계산하여 water 배열에 저장한다.
		water = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				water[i][j] = maxH - land[i][j];
			}
		}
		
		// 각 칸의 물의 높이 구하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				bfs(i, j);
			}
		}
		
		// 총 물의 높이를 구한다.
		int H = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				H += water[i][j];
			}
		}
		
		// 결과 출력
		System.out.print(H);
	}
	
	public static void bfs(int r, int c) {
		
		int min = Integer.MAX_VALUE;
		boolean overRange = false;
		
		// 상하좌우의 물+벽의 크기가 최소인 칸의 값으로 물 높이를 설정한다.
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위를 벗어나면 물을 모두 흡수하므로 몰의 높이는 0
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
				water[r][c] = 0;
				overRange = true;
				break;
			}
			
			// 상하좌우 칸에서 벽+물의 높이가 가장 작은 값을 구한다.
			min = Math.min(min, water[nr][nc] + land[nr][nc]);
		}

		// 상하좌우 최소값을 모두 구한 후,
		if(!overRange) {
			// 현재 땅의 높이가 최소값보다 크다면 물을 채울 수 없으므로 해당 칸의 물의 높이는 0
			if(min <= land[r][c]) water[r][c] = 0;
			// 현재 땅의 높이가 최소값보다 작다면 최소값 높이까지 물을 채울 수 있으므로 해당 칸의 물의 높이는 (최소값 - 현재 땅의 높이)
			else water[r][c] = min - land[r][c];
		}
		
		// 상하좌우에서 최소값보다 큰 값을 가지는 곳으로 이동한다.
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			if(water[r][c] + land[r][c] < water[nr][nc] + land[nr][nc]) {
				bfs(nr, nc);
			}
		}
	}
}
