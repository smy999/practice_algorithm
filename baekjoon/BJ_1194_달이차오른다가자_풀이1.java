package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_1194_달이차오른다가자_풀이1 {

	static int N, M, startR, startC, min = Integer.MAX_VALUE;
	static boolean flag;
	static char[][] maze; 
	static int[] keys = {0, 0, 0, 0, 0, 0};
	static boolean[][][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new char[N][M];
		visited = new boolean[N][M][1<<6];
		
		for(int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(maze[i][j] == '0') {
					startR = i;
					startC = j;
				}
				
			}
		}
		
		queue.add(new int[] {startR, startC, 0, 0});
		visited[startR][startC][0] = true;
		bfs();
		
		if(min == Integer.MAX_VALUE) System.out.print(-1);
		else System.out.print(min);
	}
	
	private static void bfs() {

		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			int dist = tmp[2];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int key = tmp[3];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || maze[nr][nc] == '#') continue;
				
				char cell = maze[nr][nc];
				
				if(cell == '1') {
					min = dist+1;
					return;
				}
				
				if(cell >= 65 && cell <= 90) {
					if((key & (1 << (cell - 65))) == 0) continue;
				}
				
				if(cell >= 97 && cell <= 122) {
					key |= (1 << (cell - 97));
				}
				
				if(visited[nr][nc][key]) continue;
				
				visited[nr][nc][key] = true;
				queue.add(new int[] {nr, nc, dist+1, key});
				
			}
		}
	}
}
