package 정렬;

import java.io.*;
import java.util.Arrays;

public class BJ_2108_통계학 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] input = new int[N];

		// N 개의 수 입력
		int avg = 0;
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			avg += input[i];
		}

		// 1. 평균 계산 & 출력
		bw.write((int)Math.round(avg/(double)N) + "\n");

		// 정렬
		Arrays.sort(input);

		// 아랮 정렬은 시간초과
		//		for(int i = 0; i < N; i++) {
		//			for(int j = i+1; j < N; j++) {
		//				if(input[i] > input[j]) {
		//					int tmp = input[i];
		//					input[i] = input[j];
		//					input[j] = tmp;
		//				}
		//			}
		//		}

		// 2. 중앙값 계산 및 출력
		bw.write(input[N/2] + "\n");

		// 3. 최빈값 계산 및 출력
		// 최소 입력값 = -4000, 최대 입력값 = 4000
		int[] count = new int[8001];

		// 입력 수 카운
		for(int i = 0; i < N; i++)
			count[input[i]+4000]++;

		// 최대 빈도 구하기
		int cntMax = 0;
		for(int i = 1; i < 8001; i++)
			if(cntMax < count[i]) cntMax = count[i];

		// 최빈값(들 구하기)
		int mode = 0;
		boolean hasMode = false;
		for(int i = 0; i < 8001; i++) {
			if(cntMax == count[i]) {
				if(hasMode) {
					mode = i-4000;
					break;
				}
				mode = i-4000;
				hasMode = true;
			}
		}

		// 최빈값 출력
		bw.write(mode + "\n");

		// 4. 범위 계산 및 출력
		bw.write(input[N-1] - input[0] + "\n");

		br.close();
		bw.flush();
		bw.close();
	}
}
