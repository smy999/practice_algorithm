import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_1012_유기농배추_BFS {
	static int T, M, N, K, x, y, cnt;
	static int[][] land;
	static Queue<int[]> queue;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			land = new int[M][N];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				land[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
			}
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(land[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	private static void bfs(int i, int j) {
		queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		land[i][j] = 0;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N || land[nr][nc] == 0) continue;
				
				queue.add(new int[] {nr, nc});
				land[nr][nc] = 0;
			}
		}
	}
}
