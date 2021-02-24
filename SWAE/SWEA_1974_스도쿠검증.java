package IM_20210224;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {
	
	static int[][] sudoku;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sudoku = new int[9][9];
		
		boolean exit;
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {

			exit = false;
			
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0; i < 9; i++) {
				check = new boolean[10];
				for(int j = 0; j < 9; j++) {
					if(check[sudoku[i][j]] == true) {
						exit = true;
						break;
					}
					check[sudoku[i][j]] = true;
				}
				if(exit) break;
			}

			if(!exit) {
				for(int i = 0; i < 9; i++) {
					check = new boolean[10];
					for(int j = 0; j < 9; j++) {
						if(check[sudoku[j][i]] == true) {
							exit = true;
							break;
						}
						check[sudoku[j][i]] = true;
					}
					if(exit) break;
				}
			}

			if(!exit) {
				loop: for(int i = 0; i < 7; i+=3) {
					for(int j = 0; j < 7; j+=3) {
						check = new boolean[10];
						for(int i2 = 0; i2 < 3; i2++) {
							for(int j2 = 0; j2 < 3; j2++) {
								if(check[sudoku[i2+i][j2+j]] == true) {
									exit = true;
									break loop;
								}
								check[sudoku[i2+i][j2+j]] = true;
							}
						}
					}
				}
			}

			if(exit) System.out.println("#" + t + " 0");
			else System.out.println("#" + t + " 1");
		}
	}
}
