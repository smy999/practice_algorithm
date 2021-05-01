import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class BJ_16918_봄버맨_풀이2 {

	static int R, C, N;
	static char[][] grid;
	static int[][] clock;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		grid = new char[R][];
		clock = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			grid[i] = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == 'O') {
					queue.add(new int[] {i, j});
					clock[i][j] = 3;	// 초기 설정이 폭탄이면 시간을 3으로 설정하여 3초뒤 터진 후에 폭탄이되지 않도록 한다.
				}
			}
			// System.out.println(Arrays.toString(grid[i])); // 확인 출력
		}
		
		// 범위 주의 N초도 포함해야 한다.
		for(int n = 1; n <= N; n++) {
			if(n % 2 == 0) install(n);
			else explode(n);
			
//			for(int i = 0; i < R; i++) {	// 확인 출력
//				System.out.println(Arrays.toString(grid[i]));
//			}
//			System.out.println();
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(grid[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void install(int n) {
		// 일단 모든 곳에 폭단 설치
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == '.') {
					grid[i][j] = 'O';
					clock[i][j] = n+3;
				}
			}// for j
		}// for i
	}
	
	private static void explode(int n) {
		// 원래 n초에 터질 애들이었던 애들 골라내
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(clock[r][c] == n) 
					explode(r, c, n);
			} // for c
		} // for r
	}
	
	private static void explode(int r, int c, int n) {
		grid[r][c] = '.';	// 원래 n초에 터질 애들 땅으로 변경

		for(int d = 0; d < 4; d++) {	// 원래 n초에 터질 애들을 중심으로 4방에 존재하는 애들도 땅으로 변경
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			
			// 원래 터질 애는 아니었지만 원래 터질 애 4방에 존재하는 애들 폭파
			if(grid[nr][nc] == 'O' && clock[nr][nc] != n) {
				clock[nr][nc] = 0;
				grid[nr][nc] = '.';
			}
		}// for
	}
}
