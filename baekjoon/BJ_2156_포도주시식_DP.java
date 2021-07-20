package July_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2156_포도주시식_DP {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] glass = new int[N+1];
		for(int i = 1; i <= N; i++) glass[i] = Integer.parseInt(br.readLine());
		
		int[] DP = new int[N+1];
		DP[1] = glass[1];
		if(N > 1) {
			DP[2] = glass[1]+glass[2];
			for(int i = 3; i <= N; i++) {
				DP[i] = Math.max(glass[i]+glass[i-1]+DP[i-3], 	// 지금이 2번 연속일 때
						Math.max(glass[i]+DP[i-2], 				// 지금이 1번일 때
						DP[i-1]));								// 지금이 0번일 때 = 마시지 않았을 때
			}
		}
		
		System.out.print(DP[N]);
	}
	
 }
