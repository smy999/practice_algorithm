package workshop;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {

	static int T, N, min;		// 테스트케이스, 식재료 개수, 맛 차이 최소값
	static int[][] ingredients;	// 입력 식재료 배열
	static boolean[] select;	// A, B로 식재료를 나누기 위한 boolean 배열
	static int[] A, B;			// 음식 A, B에 들어갈 재료 배열
	static StringTokenizer st;	// 입력 공백 분리
	static StringBuilder sb = new StringBuilder();	// 테스트케이스 별 문자열 입력 후 프로그램 종료 직전 한번에 결과 출력

	public static void main(String[] args) throws IOException {

		// 파일 입력
		System.setIn(new FileInputStream("input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());	// 테스트케이스

		for(int t = 1; t <= T; t++) {

			// 초기화
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());

			// 입력 배열 크기 할당
			ingredients = new int [N][N];
			select = new boolean[N];
			A = new int[N/2];
			B = new int[N/2];

			// 식재료 배열 입력
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					ingredients[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 조합 NCN/2: A, B로 식재료 그룹을 나눈다.
			divideAB(0, 0);

			// 결과 출력
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	/* method divide()
	 * 1. 음식 A, B 별로 식재료 나누기
	 * 2. 음식 별 시너지 합 계산
	 * 3. 맛 차이 최소값 구하기 
	 *  */
	private static void divideAB(int cnt, int idx) {
		// 기저조건
		if(cnt == N/2) {

			// 음식 A, B 별로 식재료 분리
			int aIdx = 0;
			int bIdx = 0;

			for(int i = 0; i < N; i++) {
				if(select[i]) A[aIdx++] = i;
				else B[bIdx++] = i;
			}
			
			// A, B 각각 맛(시너지 합 )계산
			int flavorA = getFlavor(A);
			int flavorB = getFlavor(B);
			
			// A와 B의 맛의 차이를 구해 최소값 구하기
			min = Math.min(min, (int)Math.abs(flavorA - flavorB));
			
			return;
		}

		if(idx == N) return;
		
		select[idx] = true;		// 선택
		divideAB(cnt+1, idx+1);
		select[idx] = false;	// 미선택
		divideAB(cnt, idx+1);

	}

	/*
	 * method getFlanor
	 * 1. 입력으로 들어온 음식(A or B)의 시너지 합을 구해 divide()로 반환한다.
	 */
	private static int getFlavor(int[] a) {
		int sum = 0;
		for(int i = 0; i < N/2; i++)
			for(int j = i+1; j < N/2; j++)
				sum += ingredients[a[i]][a[j]] + ingredients[a[j]][a[i]];
		return sum;
	}
}
