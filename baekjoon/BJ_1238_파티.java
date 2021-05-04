import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1238_파티 {

	static int N, M, X, max;
	static int[][] dijkstra;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;	
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dijkstra = new int[N+1][N+1];
		
		// 한번에 자기 자신으로 가는 길을 없다.
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				dijkstra[i][j] = 9999999;	// Integer.MAX_VALUE는 오류	
			}
		}
		
		// 단방향
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			if(dijkstra[start][end] > time) dijkstra[start][end] = time;	// 비교 왜하는거야? 비교하면 시간이 더 빨라야하는 거 아닌가?
		}
		
		// 갈 수 있는 최소 거리 구하기
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(dijkstra[i][j] > dijkstra[i][k] + dijkstra[k][j])
						dijkstra[i][j] = dijkstra[i][k] + dijkstra[k][j];
				}
			}
		}
		
		// 어떤 집 => X, 다시 X => 어떤 집
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, (dijkstra[i][X]+dijkstra[X][i]));
		}
		
		System.out.print(max);
		br.close();
	}
}
