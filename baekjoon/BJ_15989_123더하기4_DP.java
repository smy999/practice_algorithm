package Feb_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_15989_123더하기4_DP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] DP = new int[10001][4];
		DP[1][1] = DP[2][1] = DP[2][2] = DP[3][1] = DP[3][2] = DP[3][3] = 1;
		
		for(int i = 4; i <= 10000; i++) {
				DP[i][1] = DP[i-1][1];
				DP[i][2] = DP[i-2][1] + DP[i-2][2];
				DP[i][3] = DP[i-3][1] + DP[i-3][2] + DP[i-3][3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int idx = Integer.parseInt(br.readLine());
			sb.append(DP[idx][1] + DP[idx][2] + DP[idx][3]).append("\n");
		}
		
		System.out.println(sb);
	}
}
