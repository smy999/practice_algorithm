package IM_20210224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1037_오류교정 {

	static int[][] bits;
	static int N;

	// Idea1: 행과 열의 합을 함께 구한다.
	static boolean sumCheck() {
		for(int i = 0; i < bits.length; i++) {
			int isum = 0;
			int jsum = 0;
			for(int j = 0; j < bits.length; j++) {
				isum += bits[i][j];
				jsum += bits[j][i];
			}
			if(isum%2==1) return false;
			if(jsum%2==1) return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		bits = new int[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				bits[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(sumCheck()) {
			System.out.println("OK");
		}
		else {
			boolean corrupted = true;
			loop: for(int i = 0; i < N; i++) {	// Idea3: 2중 for문 이상일 때 반복문 탈출하기
				for(int j = 0; j < N; j++) {
					bits[i][j] = bits[i][j] == 0? 1 : 0;	// Idea2: 1과 0 바꾸기
					if(sumCheck()) {
						System.out.println("Change bit (" + (i+1) + "," + (j+1) + ")");
						corrupted = false;
						break loop;				// Idea3: 2중 for문 이상일 때 반복문 탈출하기
					}
					bits[i][j] = bits[i][j] == 0? 1 : 0;	// Idea2: 원상복구
				}
			}
			if(corrupted) System.out.println("Corrupt");
		}

	}
}
