package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1309_동물원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] DP = new int[N][3];
		
		
		DP[0][0] = DP[0][1] = DP[0][2] = 1;
		for(int i = 1; i < N; i++) {	// 오류1: 0부터 시작해서
			// 오류2: 마지막뿐만 아니라 매면 9901로 나눠야 한다.
			DP[i][0] = (DP[i-1][1] + DP[i-1][2])%9901;
			DP[i][1] = (DP[i-1][0] + DP[i-1][2])%9901;
			DP[i][2] = (DP[i-1][0] + DP[i-1][1] +DP[i-1][2])%9901;
		}
		
		System.out.print((DP[N-1][0]+DP[N-1][1]+DP[N-1][2])%9901);
	}
}
