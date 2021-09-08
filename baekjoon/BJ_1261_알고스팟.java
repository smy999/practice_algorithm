package Sep_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1261_알고스팟 {

//	static int M, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] maze = new char[N][];
		for(int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
		}
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
		boolean[][] visited = new boolean[N][M];
		
		pq.add(new int[] {0, 0, 0});
		visited[0][0] = true;

		while(!pq.isEmpty()) {
			int[] pos = pq.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				
				if(nr == N-1 && nc == M-1) {
					System.out.print(pos[2]);
					return;
				}
				
				visited[nr][nc] = true;
				
				if(maze[nr][nc] == '1') pq.add(new int[] {nr, nc, pos[2]+1});
				else pq.add(new int[] {nr, nc, pos[2]});
			}
		}
		
		System.out.print(0);
	}
}
