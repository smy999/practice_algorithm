package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3460_이진수_구현 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			String binaryN = Integer.toBinaryString(n);
			int len = binaryN.length();
			
			for(int i = len-1; i >= 0; i--) {
				if(binaryN.charAt(i) == '1') 
					sb.append(len-i-1).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
