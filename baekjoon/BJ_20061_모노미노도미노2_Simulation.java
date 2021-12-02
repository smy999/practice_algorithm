package Nov_week2_week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20061_모노미노도미노2 {

	static int N, score, blockCnt;
	static int[][] blockB = new int[4][6];
	static int[][] blockG = new int[6][4];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			move(t, x, y);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(score).append("\n");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 6; j++) {
				if(blockB[i][j] != 0) blockCnt++;
				if(blockG[j][i] != 0) blockCnt++;
			}
		}
		sb.append(blockCnt);
		System.out.print(sb);
	}
	
	public static void move(int t, int x, int y) {

		// move to blue block
		int idx = -1;
		if(t == 1) {
			for(int c = 1; c < 6; c++) {
				if(blockB[x][c] == 0) continue;
				idx = c-1;
				break;
			}
			if(idx == -1) blockB[x][5] = 1;
			else blockB[x][idx] = 1;
		} else if(t == 2) {
			for(int c = 1; c < 6; c++) {
				if(blockB[x][c] == 0) continue;
				idx = c-1;
				break;
			}
			if(idx == -1) blockB[x][4] = blockB[x][5] = 2;
			else blockB[x][idx-1] = blockB[x][idx] = 2;
		} else {
			for(int c = 1; c < 6; c++) {
				if(blockB[x][c] == 0 && blockB[x+1][c] == 0) continue;
				idx = c-1;
				break;
			}
			if(idx == -1) blockB[x][5] = blockB[x+1][5] = 3;
			else blockB[x][idx] = blockB[x+1][idx] = 3;
		}

		
		int cnt = 0;
		
		// remove block(full col)
		for(int i = 5; i > 1; i--) {
			cnt = 0;
			for(int r = 0; r < 4; r++) {
				if(blockB[r][i] != 0) {
					cnt++;
				}
			}
			if(cnt == 4) {
				score++;
				for(int c = i; c >= 1; c--) {
					for(int r = 0; r < 4; r++) {
						blockB[r][c] = blockB[r][c-1];
					}
				}
				i++;
			}
		}
		// remove block(col 0, 1)
		cnt = 0;
		for(int i = 0; i < 2; i++) {
			for(int r = 0; r < 4; r++) {
				if(blockB[r][i] != 0) {
					cnt++;
					break;
				}
			}
		}
		if(cnt > 0) {
			for(int c = 5; c >= 2; c--) {
				for(int r = 0; r < 4; r++) {
					blockB[r][c] = blockB[r][c-cnt];
				}
			}
			for(int r = 0; r < 4; r++) {
				blockB[r][0] = blockB[r][1] = 0;
			}
		}
		
		// move to green block
		idx = -1;
		if(t == 1) {
			for(int r = 0; r < 6; r++) {
				if(blockG[r][y] == 0) continue;
				idx = r-1;
				break;
			}
			if(idx == -1) blockG[5][y] = 1;
			else blockG[idx][y] = 1;
		} else if(t == 2) {
			for(int r = 0; r < 6; r++) {
				if(blockG[r][y] == 0 && blockG[r][y+1] == 0) continue;
				idx = r-1;
				break;
			}
			if(idx == -1) blockG[5][y] = blockG[5][y+1] = 2;
			else blockG[idx][y] = blockG[idx][y+1] = 2;
		} else {
			for(int r = 1; r < 6; r++) {
				if(blockG[r][y] == 0) continue;
				idx = r-1;
				break;
			}
			if(idx == -1) blockG[4][y] = blockG[5][y] = 3;
			else blockG[idx-1][y] = blockG[idx][y] = 3;
		}
		
		// remove block(full row)
		for(int i = 5; i > 1; i--) {
			cnt = 0;
			for(int c = 0; c < 4; c++) {
				if(blockG[i][c] != 0) {
					cnt++;
				}
			}
			if(cnt == 4) {
				score++;
				for(int r = i; r >= 1; r--) {
					for(int c = 0; c < 4; c++) {
						blockG[r][c] = blockG[r-1][c];
					}
				}
				i++;
			}
		}
		// remove block(row 0, 1)
		cnt = 0;
		for(int i = 0; i < 2; i++) {
			for(int c = 0; c < 4; c++) {
				if(blockG[i][c] != 0) {
					cnt++;
					break;
				}
			}
		}
		if(cnt > 0) {
			for(int r = 5; r >= 2; r--) {
				for(int c = 0; c < 4; c++) {
					blockG[r][c] = blockG[r-cnt][c];
				}
			}
			for(int c = 0; c < 4; c++) {
				blockG[0][c] = blockG[1][c] = 0;
			}
		}
	}
}
