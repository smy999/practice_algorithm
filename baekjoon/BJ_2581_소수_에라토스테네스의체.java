package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2581_소수_에라토스테네스의체 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[N+1];
		
		prime[0] = prime[1] = true;
				
		for(int i = 2; i*2 <= N; i++) {
			if(!prime[i]) {
				for(int j = i*2; j <= N; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i = M; i <= N; i++) {
			if(!prime[i]) {
				min = Math.min(min, i);
				sum += i;
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.print(-1);
		} else {
			System.out.print(sum + "\n" + min);
		}
	}
}
