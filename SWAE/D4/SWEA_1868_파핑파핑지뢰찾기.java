package workshop;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class SWEA_1868_파핑파핑지뢰찾기_sol {

	static int N, ans;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Point> queue = new LinkedList<>();
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			ans = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] != '.') continue;
					
					// '.' 주변의 지뢰 수 확인
					int mine = 0;
					for(int k = 0; k < 8; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						
						if(map[nr][nc] == '*') mine++;
					}
					
					if(mine == 0) {
						queue.add(new Point(i, j));
						bfs();
						ans++;
					}
				}
			}

			// '.'의 개수 계산
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.') ans++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void bfs() {
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			int r = point.r;
			int c = point.c;
			
			int mine = 0;
			for(int k = 0; k < 8; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(map[nr][nc] == '*') {
					mine++;
					break;
				}
			}
			
			map[r][c] = '^';
			
			if(mine != 0) continue;
			
			for(int k = 0; k < 8; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(map[nr][nc] != '.' || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}
		}
	}
}
