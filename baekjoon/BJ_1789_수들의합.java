package Jan_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1789_수들의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// data type 주의하기
		long S = Long.parseLong(br.readLine());
		long total = 0, inc = 1, N = 0;
		
		// 최대한 작은 수부터 1씩 더해가며 비교한다.
		while(true) {
			if(total > S) break;
			total += inc++;
			N++;
		}
		
		System.out.print(--N);
	}
}
