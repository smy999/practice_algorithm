package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2460_지능형기차2_구현 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int max = Integer.MIN_VALUE;
		int cur = 0;
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());

			int getOff = Integer.parseInt(st.nextToken());
			int getOn = Integer.parseInt(st.nextToken());
			
			cur += (getOn - getOff);
			max = Math.max(max, cur);
		}
		
		System.out.print(max);
	}
}
