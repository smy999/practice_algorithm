package com.ssafy.night.algo;

import java.io.*;
import java.util.Scanner;

public class BJ_2615_오목_While {

	static boolean flag;
	static int[][] board;

	static int[] dr = { 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input_2615.txt"));

		Scanner sc = new Scanner(System.in);

		flag = false;

		board = new int[20][20];

		for(int i = 1; i < 20; i++)
			for(int j = 1; j < 20; j++)
				board[i][j] = sc.nextInt();
		
		for(int r = 1; r < 20; r++) {
			for(int c = 1; c < 20; c++) {
				// 오목알을 하나씩 탐색하여 오목인지 확인
				if(board[r][c] != 0) {
					// 4방 탐색
					for(int d = 0; d < 4; d++) {

						int cnt = 1;

						int nr = r + dr[d];
						int nc = c + dc[d];

						// 범위 검사, 이전 오목과 같은 색인지 검사
						while(check(nr, nc) && board[nr][nc] == board[r][c]) {
							cnt++;
							nr += dr[d];
							nc += dc[d];
						}
						if(cnt == 5) {
							nr += (-6)*dr[d];
							nc += (-6)*dc[d];
							if(!check(nr, nc) || board[nr][nc] != board[r][c]) {
								System.out.println(board[r][c]);
								System.out.println(r + " " + c);
								flag = true;
							}
							else {
								continue;
							}
						}
					}
				}
			}
		}
		if(!flag) System.out.println(0);
		sc.close();
	}

	private static boolean check(int nr, int nc) {
		if(nr >= 1 && nr <= 19 && nc >= 1 && nc <= 19) return true;
		return false;
	}

}
