package workshop;

// 풀이1: 조합 사용

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2961_도영이가_만든_맛있는_음식_Subset {

	static int N, min = Integer.MAX_VALUE;	// 신맛과 쓴맛의 차이
	static StringTokenizer st;

	static int[][] input;	// 입력 재료
	static boolean[] flavorSelect;	// 사용 재료

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		input = new int[N][2];
		flavorSelect = new boolean[N];

		// 재료 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		// 배열의 크기 1부터 N까지 모두 만든다.
		combination(0);

		System.out.print(min);	// 결과 출력

		br.close();				// 스트림 닫기
	}

	static void combination(int flavorIdx) {
		if(flavorIdx == N) {
			int sour = 1;	// 초기값 1 > 곱셈
			int bitter = 0;	// 초기값 0 > 덧셈
			int cnt = 0;	// 틀렸던 이유: 공집합 제거를 안했다.

			for(int i = 0; i < N; i++) {
				if(flavorSelect[i]) {
					cnt++;
					sour *= input[i][0];	// 신맛 = 재료 신맛의 곱
					bitter += input[i][1];	// 쓴맛 = 재료 쓴맛의 합
				}
			}
			
			if(cnt == 0) return;	// 공집합이면 리턴!

			int differ = (int)Math.abs(sour-bitter);// 현재 flavor 배열의 신맛과 쓴맛의 차이 구하기

			if(differ < min) min = differ; 			// 가장 작은 차이 구하기

			return;
		}

		flavorSelect[flavorIdx] = true;
		combination(flavorIdx+1);

		flavorSelect[flavorIdx] = false;
		combination(flavorIdx+1);
	}
}
