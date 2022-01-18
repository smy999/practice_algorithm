package Jan_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2294_동전2_DP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		int[] DP = new int[K+1];
		Arrays.fill(DP, -1);
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			if(coin[i] > K) continue;
			DP[coin[i]] = 1;
			for(int j = coin[i]+1; j <= K; j++) {
				if(DP[j-coin[i]] == -1) continue;
				if(DP[j] == -1) DP[j] = 1 + DP[j-coin[i]];
				else DP[j] = Math.min(DP[j], 1 + DP[j-coin[i]]);
			}
		}
		
		System.out.print(DP[K]);
	}
}

