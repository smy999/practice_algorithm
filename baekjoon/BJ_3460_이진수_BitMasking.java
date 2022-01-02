package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3460_이진수_BitMasking {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int bit = 1;
			
			for(int i = 0; bit <= n; i++) {
				bit = 1 << i;
				if((n & bit) == bit) {
					sb.append(i).append(" ");
				}
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
}
