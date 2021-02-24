package com.ssafy.night.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠_검증 {
	static int T, isCorrect = 1; // TestCase, 체점 변수(맞으면 1, 아니면 0)
	static int[][] sudoku = new int[9][9];
	static StringTokenizer st;
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input_1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			isCorrect = 1;	// 정답 여부 초기화
			
			// 입력
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			/* 검사 아이디어: (한 행, 한 열, 3X3 배열)별로 HashSet에 추가한 후 크기가 9가 아니면 오답*/
			
			// 행 단위로 검사
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++)
					set.add(sudoku[i][j]);
				if(set.size() != 9) {
					isCorrect = 0;
					break;
				}
				set.clear();
			}
			
			// 열 단위로 검사
			if(isCorrect == 1) {	// 위 검사가 통과되었을 때만 실행
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++)
						set.add(sudoku[j][i]);
					if(set.size() != 9) {
						isCorrect = 0;
						break;
					}
					set.clear();
				}
			}
			
			// 3X3 배열 단위로 검사
			if(isCorrect == 1) {	// 위 검사가 통과되었을 때만 실행
				for(int i = 0; i < 9; i+=3) {
					for(int j = 0; j < 9; j+=3)
						sum(i, j);	// 3X3 배열의 합 구하는 함수 호출
					if(isCorrect == 0)break;
					set.clear();
				}
			}
			System.out.println("#" + t + " " + isCorrect);
		}
	}
	
	// 3X3 배열의 합 구하는 함수
	static void sum(int i, int j) {
		for(int i2 = 0; i2 < 3; i2++) {
			for(int j2 = 0; j2 < 3; j2++) {
				set.add(sudoku[i+i2][j+j2]);
			}
		}
		if(set.size() != 9) {
			isCorrect = 0;
			return;
		}
		set.clear();
	}
}
