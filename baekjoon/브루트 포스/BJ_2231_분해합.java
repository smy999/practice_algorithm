package 브루트포스;

import java.io.*;

public class BJ_2231_분해합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int tmp = N, cnt = 0;
		while (tmp > 0) {
			cnt++;
			tmp /= 10;
		}

		for (int i = N - 9 * cnt; i < N; i++) {
			int num = i, sum = i;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			if (sum == N) {
				System.out.print(i);
				return;
			}
		}
		System.out.print(0);
	}
}
