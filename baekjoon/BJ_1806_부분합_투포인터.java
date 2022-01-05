package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806_부분합_투포인터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] seq = new int[N];
		
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE, sum = 0, start = 0, end = 0;
		
		while(true) {
			if(sum >= S) {
				min = Math.min(min, end-start);
				sum -= seq[start++];
			} 
			else if(end == N) break;
			else sum += seq[end++];
		}
		
		System.out.print(min == Integer.MAX_VALUE ? 0 : min);
	}
}
