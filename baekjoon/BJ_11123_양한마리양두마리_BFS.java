
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_11123_양한마리양두마리 {
	
	static int H, W, cnt;
	static char[][] grassland;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			grassland = new char[H][W];
			
			for(int i = 0; i < H; i++)
				grassland[i] = br.readLine().toCharArray();
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(grassland[i][j] != '#') continue;
					cnt++;			// # 하나 찾을 때마다 한 무리씩 끝장본다.
					check(i, j);	// bfs
				}
			}
			
			System.out.println(cnt);
		}
		
	}
	
	private static void check(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		grassland[r][c] = '.';	// 현재위치 '.'으로 변경
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			for(int d = 0; d < 4; d++) {	// 4방 탐색
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || grassland[nr][nc] == '.') continue;
				
				queue.add(new int[] {nr, nc});	// #를 찾으면 queue에 추가
				grassland[nr][nc] = '.';		// 찾은 # -> '.'으로 변경
			}
		}
	}
}
