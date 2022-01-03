package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int n1 = a, n2 = b;
		
		while(n2 != 0) {
			int r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		
		System.out.print(n1 + "\n" + a*b/n1);
	}
}
