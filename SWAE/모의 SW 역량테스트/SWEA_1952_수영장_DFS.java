package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {

	static int price;
	static int[] tickets = new int[4];
	static int[] days = new int[12];

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
			for (int i = 0; i < 12; i++)
				days[i] = Integer.parseInt(st.nextToken());

			price = tickets[3];	// 1년은 고려할 필요 없다. 비교를 위해 초기화한다.
			dfs(0, 0);
			System.out.println("#" + t + " " + price);
		}
	}

	private static void dfs(int idx, int sum) {
		// 12 이상이면 (11까지 12월달이기 때문에) 최소값 갱신한다.
		if (idx >= 12) {
			price = Math.min(price, sum);
			return;
		}

		if (days[idx] == 0) {	// 해당 월의 수영장을 방문할 일 수가 0이면 다음으로 비용 갱신없이 넘어간다.
			dfs(idx + 1, sum);
		} else {	// 1일, 1월, 3월 별로 처리한다.
			dfs(idx + 1, sum + days[idx] * tickets[0]);
			dfs(idx + 1, sum + tickets[1]);
			dfs(idx + 3, sum + tickets[2]);
		}

	}
}
