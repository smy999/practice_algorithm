package Mar_week1_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2616_소형기관차_DP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] train = new int[N+1];
		int[] sum = new int[N+1];
		int[][] DP = new int[4][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			train[i] = Integer.parseInt(st.nextToken());
			sum[i] = train[i] + sum[i-1];
		}

		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i < 4; i++) {
			for(int j = i*n; j <= N; j++) {
				// sum[j]-sum[j-n]: 현재 칸을 포함하여 누적합의 차는 n 만큼 연속된 객차에 탐승한 승객의 합
				// DP[i-1][j-n]+sum[j]-sum[j-n]: 이전 칸에서 탐승한 최대 값 + (현재 칸~ 현재 칸-n번째 까지의 승객 합)
				DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j-n]+sum[j]-sum[j-n]);
			}
		}
		
		System.out.print(DP[3][N]);
	}
	
}
