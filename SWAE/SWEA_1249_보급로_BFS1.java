package hwalgo24_서울_13반_서민영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

// BFS

public class SWEA_1249_보급로 {

	static int N, min;
	static int[][] map;
	static int[][] time;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Info implements Comparable<Info> {
		int r, c, t;
		public Info(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
		@Override
		public int compareTo(Info info) {
			return this.t - info.t;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			time = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				String depth = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = depth.charAt(j) - '0';
					time[i][j] = Integer.MAX_VALUE;
				}
			}
			
			queue.add(new int[] {0, 0, 0});

			bfs();
			
			sb.append("#").append(t).append(" ").append(time[N-1][N-1]).append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void bfs() {
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();

			// if(info[0] == N-1 && info[1] == N-1) return;
			int t = info[2];
			
			for(int d = 0; d < 4; d++) {
				int nr = info[0] + dr[d];
				int nc = info[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

				int sum = t + map[nr][nc];
				
				if(time[nr][nc] <= sum) continue;
				
				time[nr][nc] = sum;
				
				queue.add(new int[] {nr, nc, sum});

			}
		}
	}
}
