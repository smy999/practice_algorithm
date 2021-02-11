package 재귀;

import java.util.*;

public class BJ_10872_팩토리얼 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
		
		sc.close();
	}
	
	static int factorial(int n) {
		if(n <= 1) {
			return 1;
		}
		
		return n*factorial(n-1);
	}
}
