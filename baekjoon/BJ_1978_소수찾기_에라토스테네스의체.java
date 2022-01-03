package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978_소수찾기_에라토스테네스의체 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] numArr = new int[N];		// 입력 배열
		int max = Integer.MIN_VALUE;	// 범위 지정을 위해 최대값 구하기
		
		for(int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, numArr[i]);
		}
		
		// true: not prime, false: prime
		boolean[] prime = new boolean[max+1];
		
		// 0과 1은 소수가 아니다.
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= max; i++) {
			// 소수일 때
			if(!prime[i]) {
				// 배수는 소수가 아니다.
				for(int j = i*2; j <= max; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		// 범위 안의 소수를 찾아서 카운트
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(!prime[numArr[i]]) cnt++;
		}
		
		System.out.print(cnt);
	}
}
