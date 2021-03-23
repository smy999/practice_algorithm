import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {
	
	static int N, min;
	static int[][] cost;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Math.min(cost[i-1][(j+1)%3] + cost[i][j], cost[i-1][(j+2)%3] + cost[i][j]);
			}
			
		}
		
		min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			min = Math.min(min, cost[N-1][i]);
		}
		
		System.out.print(min);
	}
}
