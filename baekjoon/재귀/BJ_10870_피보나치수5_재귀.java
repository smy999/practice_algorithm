package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10870_피보나치수5_재귀 {

	static int N, fiboN = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		fiboN = fibo(N);
		
		System.out.print(fiboN);
	}
	
	public static int fibo(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibo(n-2) + fibo(n-1);
	}
}
