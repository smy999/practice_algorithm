package Nov_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3184_양 {

	// 뒷마당 크기(R, C), 양의 수, 늑대의 수  
	static int R, C, sheepCnt = 0, wolfCnt = 0;
	
	static char[][] backyard;	// 뒷마당 배열
	static boolean[][] visited;	// 방문 배열
	
	// delta 배열
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		backyard = new char[R][C];
		visited = new boolean[R][C];
		
		for(int r = 0; r < R; r++) {
			backyard[r] = br.readLine().toCharArray();
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(visited[r][c] || backyard[r][c] == '#') continue;
				bfs(r, c);
			}
		}
		
		System.out.println(sheepCnt + " " + wolfCnt);
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		
		int sc = 0;
		int wc = 0;
		
		if(backyard[r][c] == 'o') sc++;
		if(backyard[r][c] == 'v') wc++;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || backyard[nr][nc] == '#' || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				
				queue.add(new int[] {nr, nc});
				
				if(backyard[nr][nc] == 'o') sc++;
				if(backyard[nr][nc] == 'v') wc++;
			}
		}
		
		if(sc > wc) sheepCnt += sc;
		else wolfCnt += wc;
	}
}
