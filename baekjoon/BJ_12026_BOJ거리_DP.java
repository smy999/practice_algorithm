package Mar_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_12026_BOJ거리_DP {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[] street = br.readLine().toCharArray();
		int len = street.length;
		
		int[] DP = new int[street.length];
		Arrays.fill(DP, -1);
		DP[0] = 0;

		for(int i = 0; i < len; i++) {
			if (DP[i] == -1) continue;

			// 다음 방문 문자 순서 정하기
			char next;
			if(street[i] == 'B') next = 'O';
			else if(street[i] == 'O') next = 'J';
			else next = 'B';
			
			for(int k = 1; k <= N; k++) {
				if(i + k >= len) break;					// 이동 위치가 문자열 범위를 초과할 때
				else {
					if(street[i+k] != next) continue;	// B > O > J 순서에 어긋날 때
					
					if(DP[i+k] == -1) DP[i+k] = DP[i] + k*k;		// 이전에 방문한 적이 없을 때
					else DP[i+k] = Math.min(DP[i+k], DP[i] + k*k);	// 이미 값이 있을 때 최소값으로 갱신
				}
			}
		}
		System.out.print(DP[len-1]);
		
	}
}
