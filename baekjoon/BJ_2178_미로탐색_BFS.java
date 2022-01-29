package Feb_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BJ_2178_미로탐색_BFS {

	static class Pos {
		int r, c, dist;
		public Pos(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] maze = new char[N][];
		for(int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
		}
		
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		PriorityQueue<Pos> pQueue = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
		pQueue.add(new Pos(0, 0, 1));
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		while(!pQueue.isEmpty()) {
			Pos p = pQueue.poll();
			
			if(p.r == N-1 && p.c == M-1) {
				System.out.print(p.dist);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || maze[nr][nc] == '0') continue;
				
				visited[nr][nc] = true;
				pQueue.add(new Pos(nr, nc, p.dist+1));
			}
		}
	}
}
