package Feb_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_16930_달리기_BFS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] gym = new char[N][];
		for(int i = 0; i < N; i++) gym[i] = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		int srcR = Integer.parseInt(st.nextToken())-1, srcC = Integer.parseInt(st.nextToken())-1;
		int destR = Integer.parseInt(st.nextToken())-1, destC = Integer.parseInt(st.nextToken())-1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {srcR, srcC, 0});
		
		int[][] visited = new int[N][M];

		int dr[] = {-1, 0, 1, 0};
		int dc[] = {0, 1, 0, -1};
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();

			if(cur[0] == destR && cur[1] == destC) {
				System.out.print(cur[2]);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				for(int k = 1; k <= K; k++) {
					int nr = cur[0] + dr[d] * k;
					int nc = cur[1] + dc[d] * k;
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || gym[nr][nc] == '#') break;
					
					if(visited[nr][nc] == 0) {					// 최초방문
						visited[nr][nc] = cur[2]+1;
						queue.add(new int[] {nr, nc, cur[2]+1});
					} else if(visited[nr][nc] == cur[2]+1) {	// 방문기록 있지만 시간이 같을 때
						continue;
					} else {									// 방문기록 있고 기존 시간보다 지금 시간이 더 오래걸렸을 때
						break;
					}
				}
			}
		}
		
		System.out.print(-1);
	}
} 
