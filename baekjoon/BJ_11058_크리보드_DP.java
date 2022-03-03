package Mar_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11058_크리보드_DP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] DP = new long[N+1];
		for(int i = 1; i <= N; i++) {
			// 바로 A를 출력했을 때
			DP[i] = DP[i-1]+1;
			// 3의 의미는? 전체선택 + 복사 + 붙여넣기
			for(int j = 1; j <= i-3; j++) {
				long tmp = DP[i-(j+2)]*(j+1);
				DP[i] = Math.max(DP[i], tmp);
			}
		}
		System.out.print(DP[N]);
	}

}
