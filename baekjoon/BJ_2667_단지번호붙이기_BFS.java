package Jan_week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class BJ_2667_단지번호붙이기 {

	static int N, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '0' || visited[i][j]) continue;
				bfs(i, j);
				pQueue.add(cnt);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(pQueue.size()).append("\n");
		while(!pQueue.isEmpty()) {
			sb.append(pQueue.poll()).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		cnt = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			cnt++;
			
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N 
						|| map[nr][nc] == '0' || visited[nr][nc]) continue;
				
				queue.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}
}
