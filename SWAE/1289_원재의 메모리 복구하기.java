package practice;

import java.util.Arrays;
import java.util.Scanner;

// 1289. 원재의 메모리 복구하기

public class SWEA_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Test Case 입력
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t = 1; t <= T; t++) {
			
			int cnt = 0;				// 카운트
			String str = sc.next();		// test case별 문자열 입력
			int size = str.length();	// 문자열 사이즈 저장

			// 원래 bit와 초기화 bit를 저장할 배열 생성
			int[] origin = new int[size];
			int[] reset = new int[size];

			// 문자열 받아서 문자 배열로 저장
			char[] tmp = str.toCharArray();
			
			// 원래와 초기화 배열 값 설정
			for(int i = 0; i < size; i++) {
				origin[i] = tmp[i] - '0';		// 원래 배열에 값 저장
				reset[i] = 0;					// 초기화 배열 모든 원소 0으로 값 설정
			}

			// 변환
			for(int i = 0; i < size; i++) {
				
				// 초기화 배열의 현재 인덱스의 요소가 원배 배열과 다르를 때
				if(origin[i] != reset[i]) {
					
					// 초개화 배열의 현재 위치부터 끝까지의 요소를 원래 배열의 현재 값으로 모두 변경한다.
					for(int j = i; j < size; j++) {
						reset[j] = origin[i];
					}
					++cnt;						// 변환 횟수 증가
				}
			}
			
			// 각 test case 출력
			System.out.println("#" + t + " " + cnt);
		}

	}
}
