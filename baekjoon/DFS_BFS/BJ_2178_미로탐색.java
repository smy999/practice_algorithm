
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

/* 방문배열 필요없다 */

public class BJ_2178_미로탐색 {

	static int N, M;				// 행, 열
	static int[][] map;				// 미로 배열
	// static boolean[][] visited;		// 방문 배열
	
	// delta: 4방 탐색 {상, 우, 하, 좌}
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		/* line 22~36: 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		// visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		/* 너비우선탐색 */
		bfs(0, 0);
		
		/* 결과 출력 */
		System.out.print(map[N-1][M-1]);
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			// visited[r][c] = true;
			
			for(int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d]; 
				
				// 배열 범위를 벗어날 때, 방문했던 곳일 때 다음 방향 탐색
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 1) continue;
				
				queue.offer(new int[] {nr, nc});
				// visited[nr][nc] = true;
				map[nr][nc] = map[tmp[0]][tmp[1]]+1;	// 카운트 증가해서 값 갱신
				
				if(nr == N-1 && nc == M-1) return;	// N-1, M-1에 도착하면 끝
			}
		}
	}
}
