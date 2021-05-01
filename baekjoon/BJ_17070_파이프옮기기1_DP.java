import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1_DP {

	static int N, cnt;
	static int[][] map;
	static int[][][] dpMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];		// 입력 배열
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dpMap = new int[3][N][N];	// dp 배열
		dpMap[0][0][1] = 1;			// 처음 상태: (0, 1)의 가로 방향에서 시작
		dp();						// dp 수행
		
		System.out.print(dpMap[0][N-1][N-1] + dpMap[1][N-1][N-1] + dpMap[2][N-1][N-1]);
	}
	
	// pipe 0: 가로, 1: 대각선, 2: 세로
	private static void dp() {
		for(int r = 0; r < N; r++) {
			for(int c = 2; c < N; c++) {
				// 벽
				if(map[r][c] == 1) continue;
				// 가로
				dpMap[0][r][c] = dpMap[0][r][c-1] + dpMap[1][r][c-1];	
				// 맨 위 줄인 경우는 이전에 세로, 대각선에서 왔을 수 없다.
				if(r == 0) continue;	
				// 세로
				dpMap[2][r][c] = dpMap[1][r-1][c] + dpMap[2][r-1][c];
				// 대각선: 양 옆이 벽인지 확인해야 한다.
				if(map[r-1][c] == 1 || map[r][c-1] == 1) continue;
				dpMap[1][r][c] = dpMap[0][r-1][c-1] + dpMap[1][r-1][c-1] + dpMap[2][r-1][c-1]; // 대각선	
			}
		}
	}
}
