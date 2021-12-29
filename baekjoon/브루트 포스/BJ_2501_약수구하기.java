package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2501_약수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			if(N%i == 0) cnt++;
			if(cnt == K) {
				System.out.print(i);
				return;
			}
		}
		
		System.out.print(0);
	}
}
