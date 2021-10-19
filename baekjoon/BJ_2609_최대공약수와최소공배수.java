package Oct_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		int g = gcd(n1, n2);
		
		System.out.print(g + "\n" + n1*n2/g);
	}
	
	public static int gcd(int n1, int n2) {
		while(n2 != 0) {
			int r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}
}
