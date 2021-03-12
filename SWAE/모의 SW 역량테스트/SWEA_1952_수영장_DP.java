package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class SWEA_1952_수영장_DP {

	static int[] tickets = new int[4];
	static int[] price = new int[15];

	public static void main(String[] args) throws Exception {
		// line 16~29: 입력
		System.setIn(new FileInputStream("input_1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				tickets[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 3; i <= 14; i++) {
				price[i] = Integer.parseInt(st.nextToken());
				// 여기까지 입력
				// 여기부터 dp
				// 1. 1일, 1달 비교
				// 2. 앞의 최소값과 3달 비교
				price[i] = Math.min(Math.min(price[i-1]+price[i]*tickets[0], price[i-1]+tickets[1])
									, price[i-3]+tickets[2]);
			}
			// 3. 앞의 최소값과 1년 비교
			System.out.println("#" + t + " " + Math.min(price[14], tickets[3]));
		}
	}
}
