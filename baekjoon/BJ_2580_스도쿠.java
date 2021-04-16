package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2580_스도쿠 {

	static int[][] sudoku = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		play(0, 0);
		
	}
	
	private static void play(int r, int c) {
		if(c == 9) {
			play(r+1, 0);
			return;
		}
		
		if(r == 9) {
 			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}
		
		if(sudoku[r][c] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(check(r, c, i)) {
					sudoku[r][c] = i;
					play(r, c+1);
				}
			}
			sudoku[r][c] = 0;
			return;
		}
		
		play(r, c+1);
	}
	
	private static boolean check(int r, int c, int n) {
		for(int i = 0; i < 9; i++) {
			if(sudoku[r][i] == n) return false;
		}

		for(int i = 0; i < 9; i++) {
			if(sudoku[i][c] == n) return false;
		}

		int nr = r/3*3, nc = c/3*3;
		
		for(int i = nr; i < nr+3; i++) {
			for(int j = nc; j < nc+3; j++) {
				if(sudoku[i][j] == n) return false;
			}
		}
		return true;
	}
}



/*
 *
 * 
 
garo(r, c, i) && sero(r, c, i) && threeByThree(r, c, i)
 
 	private static boolean garo(int r, int c, int n) {
		for(int i = 0; i < 9; i++) {
			if(sudoku[r][i] == n) return false;
		}
		return true;
	}
	
	private static boolean sero(int r, int c, int n) {
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][c] == n) return false;
		}
		return true;
	}
	
	private static boolean threeByThree(int r, int c, int n) {
		int nr = r/3*3, nc = c/3*3;
		
		for(int i = nr; i < nr+3; i++) {
			for(int j = nc; j < nc+3; j++) {
				if(sudoku[i][j] == n) return false;
			}
		}
		return true;
	}
}
 
 
	private static int sero(int r, int c) {
		int num = 45, cnt = 8;
		for(int i = 0; i < 9; i++) {
			if(i == r) continue;
			if(sudoku[i][c] == 0) {
				cnt--;
				break;
			}
			num -= sudoku[i][c];
		}
		if(cnt == 8) return num;
		else return 0;
	}
*/
