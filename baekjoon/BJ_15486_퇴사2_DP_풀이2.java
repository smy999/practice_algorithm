package Feb_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2_DP {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N+2];
		int[] P = new int[N+2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] DP = new int[N+2];
		int max = 0;
		for(int i = 1; i < N+2; i++) {
			// 지금까지 모은 상담비와 현재 상담비를 비교하여 큰 값을 저장
			max = Math.max(max, DP[i]);
			// 상담이 끝나는 날 구하기
			int next = i + T[i];
			// 상담이 끝나는 날 기존 최대값과 i번째 날 상담을 했을 때 상담비를 비교한다.
			if(next < N+2) DP[next] = Math.max(DP[next], max+P[i]);
		}
		
		System.out.print(max);
	}

}
