package Mar_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10422_괄호_DP {

	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 시작부터 가능한 모든 경우를 계산한다.
		long[] DP = new long[5001];
		DP[0] = 1;
		DP[2] = 1;
		for(int i = 2; i <= 2500; i++) {	// 괄호는 어떤 경우에도 짝수이다.
			for(int j = 0; j < i; j++) {	// 모든 경우의 수 구하기
				DP[i*2] += (DP[j*2]*DP[(i-j-1)*2]);
				DP[i*2] %= 1000000007L;		// 각 테스트케이스에 대해 모두 나눠준다.
			}
		}
		
		// 입력
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			sb.append(DP[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.print(sb);
	}
}
