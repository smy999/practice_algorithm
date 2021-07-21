package July_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BJ_22116_창영이와퇴근 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(N == 1) {
			System.out.print(0);
			return;
		}
		
		int[][] slope = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				slope[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> { return p1[2] - p2[2]; });
		pq.add(new int[] {0, 0, 0});
		
		while(!pq.isEmpty()) {
			int[] load = pq.poll();
			int r = load[0];
			int c = load[1];
			int max = load[2];
			
			if(r == N-1 && c == N-1) {
				System.out.print(slope[r][c]);
				break;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				int next = Math.max(max, Math.abs(map[nr][nc]-map[r][c]));
				
				if(next < slope[nr][nc]) {
					slope[nr][nc] = next;
					pq.add(new int[] {nr, nc, next});
				}
			}
		}

	}
}
