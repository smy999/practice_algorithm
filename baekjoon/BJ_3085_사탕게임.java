package Sep_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3085_사탕게임 {

	static int N, max;
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][];
		
		// 사탕 채우기
		for(int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
		
		// 동남 두방향으로만 확인
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j+1 < N && board[j][i] != board[j+1][i]) {
					swap(j, i, j+1, i);
					findMax();
					swap(j, i, j+1, i);
				}
				
				if(j+1 < N && board[i][j] != board[i][j+1]) {
					swap(i, j, i, j+1);
					findMax();
					swap(i, j, i, j+1);
				}
				
				if(max == N) {
					System.out.print(max);
					return;
				}
			}
		}
		
		System.out.print(max);
	}
	
	public static void findMax() {

		int cnt = 0;
		char last = '0';
		
		// 열 검사
		for(int i = 0; i < N; i++) {
			last = board[i][0];
			cnt = 1;
			for(int j = 1; j < N; j++) {
				if(last == board[i][j]) cnt++;
				else cnt = 1;
				
				max = Math.max(max, cnt);
				last = board[i][j];
			}
		}
	
		// 행 검사
		for(int i = 0; i < N; i++) {
			last = board[0][i];
			cnt = 1;
			for(int j = 1; j < N; j++) {
				if(last == board[j][i]) cnt++;
				else cnt = 1;

				max = Math.max(max, cnt);
				last = board[j][i];
			}
		}
	}
	
	public static void swap(int r1, int c1, int r2, int c2) {
		char tmp = board[r1][c1];
		board[r1][c1] = board[r2][c2];
		board[r2][c2] = tmp;
	}
}
