package Jan_week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1_DFS {

	static int N, cnt;
	static int[][] house;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 0, 1};
	static boolean[][] visited;
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		house = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][N];
		visited[0][0] = visited[0][1] = true;
		
		dfs(0, 1, 0);
		
		System.out.print(cnt);
	}
	
	public static void dfs(int r, int c, int dir) {
		if(r == N-1 && c == N-1) {
			cnt++;
			return;
		}
		
		if(dir == 0) {
			for(int d = 0; d < 3; d++) {
				if(d == 1) continue;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= N || nc >= N || house[nr][nc] == 1 || visited[nr][nc]) continue;
				if(d == 2 && (house[r+dr[0]][c+dc[0]] != 0 || house[r+dr[1]][c+dc[1]] != 0 
						|| visited[r+dr[0]][c+dc[0]] || visited[r+dr[1]][c+dc[1]])) continue;
				visited[nr][nc] = true;
				dfs(nr, nc, d);
				visited[nr][nc] = false;
			}
		} else if(dir == 1) {
			for(int d = 0; d < 3; d++) {
				if(d == 0) continue;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= N || nc >= N || house[nr][nc] == 1 || visited[nr][nc]) continue;
				if(d == 2 && (house[r+dr[0]][c+dc[0]] != 0 || house[r+dr[1]][c+dc[1]] != 0 
						|| visited[r+dr[0]][c+dc[0]] || visited[r+dr[1]][c+dc[1]])) continue;
				visited[nr][nc] = true;
				dfs(nr, nc, d);
				visited[nr][nc] = false;
			}
		} else {
			for(int d = 0; d < 3; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= N || nc >= N || house[nr][nc] == 1 || visited[nr][nc]) continue;
				if(d == 2 && (house[r+dr[0]][c+dc[0]] != 0 || house[r+dr[1]][c+dc[1]] != 0 
						|| visited[r+dr[0]][c+dc[0]] || visited[r+dr[1]][c+dc[1]])) continue;
				visited[nr][nc] = true;
				dfs(nr, nc, d);
				visited[nr][nc] = false;
			}
		}
	}
}
