package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1463_1로만들기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N+1];
		
		for(int n = 2; n <= N; n++) {
			D[n] = D[n-1] + 1;
			if(n%2 == 0) D[n] = Math.min(D[n], D[n/2]+1);
			if(n%3 == 0) D[n] = Math.min(D[n], D[n/3]+1);
		}
		
		System.out.print(D[N]);
	}

}
