package 함수;

import java.io.*;

public class BJ_1065_한수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.print(hansu(N));
	}
	
	static int hansu(int N) {
		int cnt = 0;
		
		if(N < 100) return N;
		for(int n = 100; n <= N; n++) {
			if( n/100 - (n%100)/10 == (n%100)/10 - n%10 )
				cnt++;
		}
		return 99 + cnt;
	}
}
