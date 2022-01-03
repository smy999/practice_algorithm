package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10818_최소최대_구현 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			min = Math.min(min,  num);
			max = Math.max(max,  num);
		}
		
		System.out.print(min + " " + max);
	}
}
