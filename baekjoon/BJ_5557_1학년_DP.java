package Mar_week1_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_5557_1학년_DP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		long[] DP = new long[21];
		DP[numbers[0]] = 1;
		
		for(int i = 0; i < N-2; i++) {	
			long[] DP2 = new long[21];
			
			for(int j = 0; j < 21; j++) {
				if(DP[j] == 0) continue;
				
				int next = j-numbers[i+1];	// 덧셈
				if(next >= 0) DP2[next] += DP[j];
				
				next = j+numbers[i+1];		// 뺄셈
				if(next <= 20) DP2[next] += DP[j];
			}
			
			DP = DP2;
		}
		
		System.out.print(DP[numbers[N-1]]);
	}
}
