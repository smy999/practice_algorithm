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
				if(tmp[j] == 'O') grid[i][j] = 1;
			}
		}
		
		for(int n = 2; n <= N; n++) {
			if(n % 2 == 0) install(n);
			else explode(n);
		}
		
		for(int i = 0; i < R; i ++) {
			for(int j = 0; j < C; j++) {
				sb.append(grid[i][j] == 0 ? '.' : 'O');
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void install(int n) {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == 0) grid[i][j] = n;
			}
		}
	}
	
	private static void explode(int n) {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] <= n-2) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
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
