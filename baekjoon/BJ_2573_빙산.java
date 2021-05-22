import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_2573_빙산 {

	static int N, M, ans;
	static boolean isDivide;
	static int[][] iceberg;
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> queue2 = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		iceberg = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int height = Integer.parseInt(st.nextToken());
				iceberg[i][j] = height;
				if(height > 0) queue.offer(new int[] {i, j, height});
			}
		}
		
		while(!queue.isEmpty()) {
			// 주변 바닷물 카운트
			while(!queue.isEmpty()) {
				int[] ice = queue.poll();
				int cnt = 0;
				for(int d = 0; d < 4; d++) {
					int nr = ice[0] + dr[d];
					int nc = ice[1] + dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					
					if(iceberg[nr][nc] <= 0) cnt++;
				}
				queue2.offer(new int[] {ice[0], ice[1], ice[2]-cnt});
			}
			// 녹은 후 빙산 갱신
			LinkedList<int[]> list = new LinkedList<>();
			while(!queue2.isEmpty()) {
				int[] ice = queue2.poll();
				if(ice[2] <= 0) iceberg[ice[0]][ice[1]] = 0;	// 전체 개수 확인하면서 줄이기
				else list.offer(ice);
			}
			queue = new LinkedList<>(list);
			
			int cnt = 0;
			visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(iceberg[i][j] != 0 && !visited[i][j]) {
						queue2.offer(new int[] {i, j});
						visited[i][j] = true;
						while(!queue2.isEmpty()) {
							int[] ice = queue2.poll();
							for(int d = 0; d < 4; d++) {
								int nr = ice[0] + dr[d];
								int nc = ice[1] + dc[d];
								if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || iceberg[nr][nc] == 0) continue;
								visited[nr][nc] = true;
								queue2.offer(new int[] {nr, nc});
							}
						}
						cnt++;
						if(cnt >= 2) break;
					}
					if(cnt >= 2) break;
				}
				if(cnt >= 2) break;
			}
			
			ans++;
			if(cnt >= 2) {
				isDivide = true;
				break;
			}
		}
		if(isDivide) System.out.print(ans);
		else System.out.println(0);
	}
}
