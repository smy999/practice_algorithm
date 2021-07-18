package July_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5525_IOIOI_부분성공 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		
		char[] P = new char[N*2+1];
		P[0] = 'I';
		for(int i = 1; i <= N*2; i++) {
			if(i%2 == 0) P[i] = 'I'; 
			else P[i] = 'O';
		}
		
		for(int i = 0; i < M-N*2; i++) {
			if(S[i] == 'O') continue;
			
			boolean isMatch = true;
			for(int j = 0; j <= N*2; j++) {
				if(P[j] != S[i+j]) {
					isMatch = false;
					break;
				}
			}
			if(isMatch) cnt++;
		}
		
		System.out.print(cnt);
	}
}
