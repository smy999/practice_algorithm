package 브루트포스;

import java.util.Scanner;

public class BJ_1436_영화감독숌 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int series = 0;
		
		while(N > 0) {
			series++;
			String str = Integer.toString(series);
			if(str.contains("666")) N--;	
		}
		
		System.out.println(series);
		sc.close();
	}
}
