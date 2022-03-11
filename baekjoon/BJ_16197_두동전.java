package Mar_week1_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_16197_두동전 {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<int[]> queue = new LinkedList<>();
		
		char[][] board = new char[N][M];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 'o') queue.offer(new int[] {i, j, 0});
			}
		}
		
		boolean[][][] visited = new boolean[N][M][2];
		
		int min = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			int[] coin1 = queue.poll();
			int[] coin2 = queue.poll();

			int cnt = coin1[2];
			
			if(cnt > 10) break;
			
			for(int d = 0; d < 4; d++) {
				int nr1 = coin1[0] + dr[d];
				int nc1 = coin1[1] + dc[d];
				int nr2 = coin2[0] + dr[d];
				int nc2 = coin2[1] + dc[d];
				
				boolean isFall1 = false;
				boolean isFall2 = false;
				
				if(nr1 < 0 || nr1 >= N || nc1 < 0 || nc1 >= M) isFall1 = true;
				if(nr2 < 0 || nr2 >= N || nc2 < 0 || nc2 >= M) isFall2 = true;
				
				if(isFall1 && isFall2) continue;
				
				if(isFall1 || isFall2) {
					min = Math.min(min, cnt+1);
				} else {
				    if ((!isFall1 && board[nr1][nc1] == '#') && !isFall2 && board[nr2][nc2] == '#'){
				    	continue;
				    } else if(!isFall1 && board[nr1][nc1] == '#'){
						queue.offer(new int[] {coin1[0], coin1[1], cnt+1});
						queue.offer(new int[] {nr2, nc2, cnt+1});
					} else if(!isFall2 && board[nr2][nc2] == '#') {
						queue.offer(new int[] {nr1, nc1, cnt+1});
						queue.offer(new int[] {coin2[0], coin2[1], cnt+1});
					} else {
						queue.offer(new int[] {nr1, nc1, cnt+1});
						queue.offer(new int[] {nr2, nc2, cnt+1});
					}
				} 
			}
		}
		System.out.print(min > 10 ? -1 : min);
	}
}
