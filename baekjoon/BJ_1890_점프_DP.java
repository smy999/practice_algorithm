package Feb_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1890_점프_DP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] DP = new long[N][N];
		DP[0][0] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int dist = board[i][j];
				
				if(dist == 0) break;
				
				int next = j + dist;
				if(next < N) DP[i][next] += DP[i][j];
				
				next = i + dist;
				if(next < N) DP[next][j] += DP[i][j];
			}
		}
		
		System.out.print(DP[N-1][N-1]);
	}
}
