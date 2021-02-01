package practice;

import java.util.Arrays;
import java.util.Scanner;

// 1289. 원재의 메모리 복구하기

public class SWEA_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		for(int t = 1; t <= T; t++) {
			int cnt = 0;
			String str = sc.next();
			int size = str.length();
			System.out.println(str);

			int[] origin = new int[size];
			int[] reset = new int[size];

			// 문자열 받아서 숫자 배열로 저장
			char[] tmp = str.toCharArray();
			System.out.println("tmp " + Arrays.toString(tmp));
			for(int i = 0; i < size; i++) {
				origin[i] = tmp[i] - '0';
				reset[i] = 0;
			}

			// 변환
			for(int i = 0; i < size; i++) {
				if(origin[i] != reset[i]) {
					for(int j = i; j < size; j++) {
						reset[j] = origin[i];
					}
					++cnt;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}

	}
}
