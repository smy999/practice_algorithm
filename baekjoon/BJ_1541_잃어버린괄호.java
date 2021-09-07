package Sep_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
		
		int ans = Integer.MAX_VALUE;
		
		// 앞뒤는 숫자이기 때문에 맨앞이 부호여서 생기는 문제는 없다.
		while(minus.hasMoreTokens()) {
			// 앞의 부호가 마이너스인 숫자만 저장
			int sum = 0;
			
			// +로 연결된 숫자면 분리
			StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
			// 그리고 다 더함
			while(plus.hasMoreTokens())
				sum += Integer.parseInt(plus.nextToken());
			
			// 첫숫자이면 정답에 저장, 아니면 계속 빼주
			if(ans == Integer.MAX_VALUE) ans = sum;
			else ans -= sum;
		}
		
		System.out.print(ans);
	}
}
