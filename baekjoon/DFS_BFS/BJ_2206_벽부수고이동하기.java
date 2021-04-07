
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_2206_벽부수고이동하기 {

	static int N, M, ans;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<Cell> queue = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	static class Cell {
		int r;
		int c;
		int d;
		int isBreak;
		public Cell(int r, int c, int d, int isBreak) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.isBreak = isBreak;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		visited = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		queue.add(new Cell(0, 0, 1, 0));
		
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		
		bfs();
		
		System.out.print(ans);
		
	}
	
	private static void bfs() {
		
		while(!queue.isEmpty()) {
			Cell c = queue.poll();
			
			if(c.r == N-1 && c.c == M-1) {
				ans = c.d;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = c.r + dr[d];
				int nc = c.c + dc[d];
				int nd = c.d;
				int isbreak = c.isBreak;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(map[nr][nc] == '1') {
					if(isbreak == 0 && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						queue.add(new Cell(nr, nc, nd+1, 1));
					}
				}
				
				else {
					if(!visited[nr][nc][isbreak]) {
						visited[nr][nc][isbreak] = true;
						queue.add(new Cell(nr, nc, nd+1, isbreak));
					}
				}
			}
		}
		
		ans = -1;
	}
}
