package Jan_week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1_DP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] house = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방향, 행, 열
		int[][][] dp = new int[3][N][N];
		dp[0][0][1] = 1;	// 초기 위치 표시(파이프는 가로, 0번째 행, 1번째 열에 위치)
		
		for(int r = 0; r < N; r++) {
			for(int c = 2; c < N; c++) {
				// 벽
				if(house[r][c] == 1) continue;
				
				// 가로
				dp[0][r][c] = dp[0][r][c-1] + dp[1][r][c-1];
				
				// 세로
				if(r == 0) continue;	// 배열 범위를 벗어나는 경우
				dp[2][r][c] = dp[2][r-1][c] + dp[1][r-1][c];
				
				// 대각선
				if(house[r-1][c] == 1 || house[r][c-1] == 1) continue;	// 비어있어야하는 위치 확인
				dp[1][r][c] = dp[1][r-1][c-1] + dp[0][r-1][c-1] + dp[2][r-1][c-1];
			}
		}
		
		System.out.print(dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1]);
	}
}
