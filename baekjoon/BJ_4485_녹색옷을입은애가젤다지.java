import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BJ_4485_녹색옷을입은애가젤다지 {

	static int N, min;
	static int[][] cave;
	static int[][] dijkstra;
	static PriorityQueue<Theif> pq = new PriorityQueue<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Theif implements Comparable<Theif>{
		int r, c, cost;
		public Theif(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		@Override
		public int compareTo(Theif t) {
			return this.cost - t.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());	
			
			if(N == 0) break;
			
			cave = new int[N][N];
			dijkstra = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j= 0 ; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dijkstra[i][j] = Integer.MAX_VALUE;
				}
			}
			
			sb.append("Problem " + (t++) + ": " + dijkstra() + "\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static int dijkstra() {

		dijkstra[0][0] = cave[0][0];
		pq.offer(new Theif(0, 0, dijkstra[0][0]));
		
		while(!pq.isEmpty()) {
			Theif theif = pq.poll();
			int r = theif.r;
			int c = theif.c;
			int cost = theif.cost;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(dijkstra[nr][nc] > cost + cave[nr][nc]) {
					dijkstra[nr][nc] = cost + cave[nr][nc];
					pq.offer(new Theif(nr, nc, dijkstra[nr][nc]));
				}
			}	// for : delta
		}	// while
		
		return dijkstra[N-1][N-1];
	}
}
