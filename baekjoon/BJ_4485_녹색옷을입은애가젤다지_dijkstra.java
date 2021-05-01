import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BJ_4485_녹색옷을입은애가젤다지_dijkstra {

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
			
			cave = new int[N][N];		// 입력 배열
			dijkstra = new int[N][N];	// 최소 값을 계산할 다익스트라 배열
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j= 0 ; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());	// 블랙루피 입력 배열
					dijkstra[i][j] = Integer.MAX_VALUE;	// 일단 모두 최대정수로 설정
				}
			}
			
			sb.append("Problem " + (t++) + ": " + dijkstra() + "\n");// 결과 문자열에 저장
		}
		// 결과 출력
		System.out.print(sb);
		br.close();
	}
	
	private static int dijkstra() {

		dijkstra[0][0] = cave[0][0];
		pq.offer(new Theif(0, 0, dijkstra[0][0]));
		
		// 4방으로 갈 수 있는 곳 중 블랙루피가 적은 곳을 선택해 간다.
		while(!pq.isEmpty()) {
			Theif theif = pq.poll();
			int r = theif.r;
			int c = theif.c;
			int cost = theif.cost;
			
			// N일때 나가기
//			if(r == N-1 && c == N-1)  
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				// 그냥 가는 것과 경유해 하는 것 중 작은 값을 넣는다.
				if(dijkstra[nr][nc] > cost + cave[nr][nc]) {	
					dijkstra[nr][nc] = cost + cave[nr][nc];
					pq.offer(new Theif(nr, nc, dijkstra[nr][nc]));
				}
			}// for : delta
		}// while
		
		return dijkstra[N-1][N-1];
	}
}
