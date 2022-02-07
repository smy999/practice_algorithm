package Feb_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16953_AtoB {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		
		while(true) {
			if(A > B) {
				System.out.print(-1);
				return;
			}
			
			if(A == B) {
				System.out.print(cnt);
				return;
			}
			
			if(B%2 == 0) B /= 2;
			else if(B%10 == 1) B /= 10;
			else {
				System.out.print(-1);
				return;
			}
			
			cnt++;
		}
	}
}
