package com.ssafy.night.algo;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_3985_롤케이크 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int expectNum = 0, actualNum = 0;	// 가장 많이 받은(을) 기대 최대값, 실제 최대값
		int expectMax = 0, actualMax = 0;	// 가장 많이 받은(을) 기대 방청객 번호, 실제 방청객 번호
		
		int[] rollCake = new int[L+1];		// L 길이의 롤케이크 배열 (인덱스 1~L사용)
		
		for(int i = 1; i <= N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());	// P
			int end = Integer.parseInt(st.nextToken());		// K
			int cnt = 0;	// 실제 받은 개수 카운트
			
			if(expectMax < end-start+1) {	// 최대 기대 개수와 방청객 구하기
				expectMax = end-start+1;
				expectNum = i;
			}
			
			for(int j = start; j <= end; j++) {	// 롤케이크 받기
				if(rollCake[j] == 0) {	// 이미 받은 사람이 있으면 pass
					rollCake[j] = i;
					cnt++;
				}
			}
			
			if(actualMax < cnt) {	// 실제 최대 개수와 발청객 구하기
				actualMax = cnt;
				actualNum = i;
			}
		}
		
		System.out.println(expectNum + "\n" + actualNum);	// 결과 출력
		
		br.close();	// 스트림 닫기
	}
}
