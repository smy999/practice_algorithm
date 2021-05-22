import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class BJ_2665_미로만들기 {

	static int N, ans;
	static char[][] checkerboard;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<int[]> queue = new LinkedList<>();
	static int[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		checkerboard = new char[N][];
		visited = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			checkerboard[i] = br.readLine().toCharArray();
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		bfs();
		
		System.out.print(visited[N-1][N-1]);
	}
	
	private static void bfs() {
		queue.offer(new int[] {0, 0});
		visited[0][0] = 0;
		
		while(!queue.isEmpty()) {
			int[] room = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = room[0] + dr[d];
				int nc = room[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(visited[nr][nc] <= visited[room[0]][room[1]]) continue;
				
				if(checkerboard[nr][nc] == '0') visited[nr][nc] = visited[room[0]][room[1]]+1;
				else visited[nr][nc] = visited[room[0]][room[1]];
				queue.offer(new int[] {nr, nc});
			}
		}
	}
}
