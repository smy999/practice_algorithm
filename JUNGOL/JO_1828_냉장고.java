package com.ssafy.night.algo;

import java.io.*;
import java.util.*;

public class JO_1828_냉장고 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());	// 화학 물질 개수

		int[][] arr = new int[N][2];

		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());

			arr[n][0] = Integer.parseInt(st.nextToken());	// 최저 온도 값
			arr[n][1] = Integer.parseInt(st.nextToken());	// 최고 온도 값
		}

		Arrays.sort(arr, new Comparator<int[]>() {	// 최고 온도 기준으로 출력
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int refrigerator = 1;	// 냉장고 개수, 1부터 시작
		int max = arr[0][1];	// 비교를 위한 제일 첫 번째 화학물질의 최고 온도 값 저장
		
		for(int i = 1; i < N; i++) {
			if(max < arr[i][0]) {	// i 이전의 최고 온도 값이 i+1의 최저 온도보다 낮다면
				refrigerator++;		// 냉장고 1대 더 필요
				max = arr[i][1];	// max 값 i+1의 최고 온도로 갱신
			}
		}

		System.out.println(refrigerator);	// 결과 출력
	}
}



/*

input

4
-15 5
-10 36
10 73
27 44
*/
