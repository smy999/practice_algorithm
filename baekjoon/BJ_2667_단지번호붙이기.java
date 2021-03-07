
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BJ_2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static Queue<int[]> queue;
	static PriorityQueue<Integer> complex = new PriorityQueue<>();
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		char[] tmp;
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().toCharArray();
			for(int j = 0; j < N; j++)
				map[i][j] = tmp[j]-'0';
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(map[i][j] == 1)
					bfs(i, j);

		StringBuilder sb = new StringBuilder(complex.size() + "\n");
		while(!complex.isEmpty()) sb.append(complex.poll() + "\n");
		sb.setLength(sb.length()-1);
		
		System.out.print(sb);
	}
	
	private static void bfs(int i, int j) {
		queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		map[i][j] = 0;
		int dist = 1;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for(int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 1) continue;
				
				map[nr][nc] = 0;
				dist++;
				queue.add(new int[] {nr, nc});
			}
		}	
		complex.add(dist);
	}
}


