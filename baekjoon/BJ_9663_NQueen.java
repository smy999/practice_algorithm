package Aug_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9663_NQueen {

	static int N, ans;
	static int[] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N];	// 체스판 생성(행 단위)
		
		arrangeQ(0);	// Q 배치 
		
		System.out.println(ans);	// 결과 출력
	}
	
	// r: 행 위치, c: 열 위치, cnt: 배치된 Q의 수
	public static void arrangeQ(int r) {
		if(r == N) {	// N번째 행까지 모두 검사했을 때
			ans++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			board[r] = i;
			if(findQ(r)) {
				arrangeQ(r+1);
			}
		}
	}
	
	// return true: 해당 위치에 Q 놓을 수 있음
	// return false: 해당 위치에 Q 놓을 수 없음
	public static boolean findQ(int r) {
		for(int i = 0; i < r; i++) {
			// 열 검사
			if(board[i] == board[r]) return false;
			
			// 대각선 검
			if(Math.abs(r-i) == Math.abs(board[r] - board[i])) return false;
		}
		return true;
	}
}
