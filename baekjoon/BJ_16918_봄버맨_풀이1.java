import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;


public class BJ_16918_봄버맨_풀이1 {

	static int R, C, N;
	static int[][] grid;
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
		
		grid = new int[R][C];
		
		for(int i = 0; i < R; i ++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(tmp[j] == 'O') grid[i][j] = 1;	// 폭단이 있는 자리는 1로
			}
		}
		// 여기까지 입력
		
		// N초 동안 반복
		for(int n = 2; n <= N; n++) {
			if(n % 2 == 0) install(n);	// 폭탄 설치
			else explode(n);			// 폭파
		}
		
		// 출력 문자열에 담기
		for(int i = 0; i < R; i ++) {
			for(int j = 0; j < C; j++) {
				sb.append(grid[i][j] == 0 ? '.' : 'O');
			}
			sb.append("\n");
		}
		
		// 결과 출력
		System.out.print(sb);
	}
	
	// 폭탄이 없는 곳에 일단 다 폭탄 설치하는데 현재 시간 입력
	private static void install(int n) {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == 0) grid[i][j] = n;
			}
		}
	}
	
	private static void explode(int n) {
		// 폭탄이 타 터지고 난 후 폭탄이 없어야 하는 위치 저장
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				// 3초 전에 설치된 폭탄이면 모든 폭탄이 폭파하고 난 후, '.' 상채로 변경한다.
				if(grid[i][j] <= n-2) {	
					queue.add(new int[] {i, j});
				}
			}
		}
		
		// 원래 폭탄이 있던 자리에서 4방으로 탐색하며 폭탄이 터진 후 폭탄이 없은 위치를 표시한다.
		while(!queue.isEmpty()) {
			int[] bomb = queue.poll();
			int r = bomb[0];
			int c = bomb[1];
			
			grid[r][c] = 0;
			
			for(int d = 0; d< 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				
				grid[nr][nc] = 0;
			}
		}
	}
}




//char[][] https://suhyeokeee.tistory.com/200
//int[][] https://m.blog.naver.com/PostView.nhn?blogId=kerochuu&logNo=221566176340&proxyReferer=https:%2F%2Fwww.google.com%2F
