package Oct_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2239_스토쿠 {

	static int[][] board;		// 스도쿠 보드
	static List<Pos> list;		// 채워야 할 칸 리스트
	
	public static class Pos {	// 위치 정보 클래스
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		list = new ArrayList<>();
		
		// 입력
		for(int i = 0; i < 9; i++) {
			String line = br.readLine();
			for(int j = 0; j < 9; j++) {
				board[i][j] = line.charAt(j) - '0';
				if(board[i][j] == 0) list.add(new Pos(i, j));	// 입력 받으면서 채워야할 자리 저장하기
			}
		}
		
		// 스도쿠 시작
		gameOn(0);
	}
	
	public static void gameOn(int idx) {
		
		// 모두 채웠을 때 결과 출력하고 종료
		if(list.size() == idx) {
			StringBuilder sb = new StringBuilder();
			for(int[] line : board) {
				for(int num : line) sb.append(num);
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}
		
		// 현재(지금 채워야할 칸) 위치 받아오기
		int r = list.get(idx).r;
		int c = list.get(idx).c;
		
		// 채워지면 안되는 수를 거르기 위한 배열
		boolean[] match = new boolean[10];
		
		// row
		for(int j = 0; j < 9; j++) {
			if(board[r][j] != 0) match[board[r][j]] = true;
		}
		
		// col
		for(int i = 0; i < 9; i++) {
			if(board[i][c] != 0) match[board[i][c]] = true;
		}
		
		// 3*3
		int nr = (r/3)*3;
		int nc = (c/3)*3;
		for(int i = nr; i < nr+3; i++) {
			for(int j = nc; j < nc+3; j++) {
				if(board[i][j] != 0) match[board[i][j]] = true;
			}
		}
		
		// 1~9까지 아직 채워지지 않은 칸이 있으면 일단 채우고 다음 칸 가기
		// 아니면 돌아와서 다시 0으로 만들고 다음 경우의 수 판단
		// 스도투 채울 때 가장먼저 채워진 답이 최종 답이다.(오름차순)
		for(int i = 1; i < 10; i++) {
			if(!match[i]) {
				board[r][c] = i;
				gameOn(idx+1);
				board[r][c] = 0;
			}
		}
	}
}
