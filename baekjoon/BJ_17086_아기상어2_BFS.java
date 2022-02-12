package Feb_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086_아기상어2_BFS {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sea = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		
		int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
		int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)  {
				if(sea[i][j] == 1) continue;
				
				boolean[][] visited = new boolean[N][M];
				visited[i][j] = true;
				
				Queue<int[]> queue = new LinkedList<>(); 
				queue.add(new int[] {i, j, 0});
				
				while(!queue.isEmpty()) {
					int[] cur = queue.poll();
					
					if(sea[cur[0]][cur[1]] == 1) {
						// 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리. 그중에서 최대값 찾기
						max = Math.max(max, cur[2]);
						break;
					}
					
					for(int d = 0; d < 8; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
						
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc, cur[2]+1});
					}
				}
			}
		}
		
		System.out.print(max);
	}

}
