package Feb_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

// 뭉쳐있다? BFS
// 아군 - 백, 적군 - 청

public class BJ_1303_전쟁전투_BFS {

	static int N, M, cntW, cntB;	// 전쟁터 크기, 각국의 위력
	static char[][] bg;	// bg(battle ground) 전쟁터
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		bg = new char[N][M];	
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			bg[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				bfs(i, j, bg[i][j]);
			}
		}
		
		System.out.print(cntW + " " + cntB);
	}
	
	public static void bfs(int r, int c, char color) {	
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || color != bg[nr][nc]) continue;
				
				visited[nr][nc] = true;
				queue.add(new int[] {nr, nc});
				cnt++;
			}
		}
		
		if(bg[r][c] == 'W') cntW += (cnt*cnt);
		else cntB += (cnt*cnt);
		
		
	}
}
