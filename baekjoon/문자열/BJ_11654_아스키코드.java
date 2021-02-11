package 문자열;
import java.util.Scanner;


public class BJ_11654_아스키코드 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		char c = sc.nextLine().charAt(0);
		int n = (int)c;
		System.out.println(n);
		sc.close();
	}
}
