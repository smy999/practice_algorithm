package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978_소수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		// 소수의 개수
		int cnt = N;
		
		// 소수가 아닌 수를 찾아서 소수의 개수를 감소시킨다.
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(n == 1) cnt--;	// 1은 소수가 아니다.
			
			// 1보다 크고 n보다 작은 수로 나누어 떨어지면 소수가 아니다.
			for(int j = 2; j < n; j++) {
				if(n%j == 0) {
					cnt--;
					break;
				}
			}
		}
		
		System.out.print(cnt);
	}
}
