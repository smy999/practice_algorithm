package Aug_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BJ_6593_상범빌딩 {

	// 동서남북상하
	static int[] dr = {0, 0, 1, -1, 0, 0};
	static int[] dc = {1, -1, 0, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			char[][][] building = new char[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];
			
			// 종료 조건
			if(L == 0 && R == 0 && C == 0) break;
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[3] - pq2[3]);
			
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					String cols = br.readLine();
					for(int k = 0; k < C; k++) {
						building[i][j][k] = cols.charAt(k);
						if(building[i][j][k] == 'S') {
							pq.add(new int[] {i, j, k, 0});
							visited[i][j][k] = true;
						}
					}
				}
				// 층 하나 당 줄바꿈 하나씩 제거
				br.readLine();
			}

			int minutes = 0;
			
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				
				// 탈출 조건: 출구 찾으면 시간 저장 후 반복문 나가기
				if(building[cur[0]][cur[1]][cur[2]] == 'E') {
					minutes = cur[3];
					break;
				}
				
				for(int d = 0; d < 6; d++) {
					int nz = cur[0] + dz[d];
					int nr = cur[1] + dr[d];
					int nc = cur[2] + dc[d];
					
					if(nz < 0 || nz >= L || nr < 0 || nr >= R || nc < 0 || nc >= C 
							|| building[nz][nr][nc] == '#' || visited[nz][nr][nc]) continue;
					
					pq.add(new int[] {nz, nr, nc, cur[3]+1});
					visited[nz][nr][nc] = true;
				}
			}
			
			if(minutes != 0) sb.append("Escaped in " + minutes + " minute(s).\n");
			else sb.append("Trapped!\n");
		}
		
		System.out.print(sb);
	}
}
