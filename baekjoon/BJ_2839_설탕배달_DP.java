package workshop;

// 풀이: DP(Dynamic Programming)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2839_설탕배달_DP {
	
	public static void main(String[] args) throws IOException{
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 배달해야하는 설탕 kg
		br.close();	// 입력 끝. 스트림 닫기
		
		// 5이하의 설탕 무게 처리
		if(N <= 5) {
			if(N == 3 || N == 5) System.out.print("1");
			else System.out.print("-1");
			return;
		}
		
		// dp = 메모이제이션(재사용을 위한 단계별 기록)
		int[] dp = new int[N+1];	// 0은 dummy
		Arrays.fill(dp, 5000); 		// 모든 원소의 값을 5000으로 초기화(5000: N의 최대값)
		
		// dp[3] : 3kg을 만드는 데 필요한 최소 봉지 수: 1
		// dp[2] : 2kg을 만드는 데 필요한 최소 봉지 수: 없어! = 5000
		
		// 3kg, 5kg를 쓸 수 있다는 초기값 설정
		// 만약, 4kg, 7kg도 추가해야 한다면? 이부분에 추가해! dp는 확장이 가능하다.
		dp[3] = 1;
		dp[5] = 1;
		
		// dp[i] = dp[i-3];
		// i == 8kg => dp[8] = dp[8-3] = dp[5], dp[8-5] => dp[3]
		for(int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
		}

		if(dp[N] >= 5000) System.out.print("-1");
		else System.out.print(dp[N]);
	}
}
