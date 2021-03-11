import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

/* bfs */
// 처음에 dfs로 접근함. 어떤게 dfs이고 bfs인지 잘 생각해보자.

public class BJ_7562_나이트의이동 {
	
	static int N, knightR, knightC, destR, destC, min;
	static boolean[][] visited;
	static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dc = {-1, 1, 2, 2, -1, 1, -2, -2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			knightR = Integer.parseInt(st.nextToken());
			knightC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			destR = Integer.parseInt(st.nextToken());
			destC = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N][N];
			
			bfs(knightR, knightC, 0);
			
			System.out.println(min);
		}
	}
	
	private static void bfs(int r, int c, int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c, 0});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(tmp[0] == destR && tmp[1] == destC) {
				min = tmp[2];
				break;
			}
			
			for(int d = 0; d < 8; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				int nCnt = tmp[2] + 1;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) 
					continue;
				
				queue.add(new int[] {nr, nc, nCnt});
				visited[nr][nc] = true;
			}
		}
	}
}
