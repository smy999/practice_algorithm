package July_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class BJ_2210_숫자판점프 {

	static int[][] board;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
//			board[i] = br.readLine().toCharArray();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		String str = "";
		int num = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				num = board[i][j];
				dfs(i, j, num, 0);
//				str = "";
			}
		}
		
		System.out.print(set.size());
	}
	public static void dfs(int r, int c, int num, int cnt) {
		if(cnt == 5) {
			set.add(num);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
			
			dfs(nr, nc, num*10+board[nr][nc], cnt+1);
		}
	}
 }
