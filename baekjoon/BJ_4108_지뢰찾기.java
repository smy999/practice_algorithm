package study20210220;

import java.io.*;
import java.util.*;

public class BJ_4108_지뢰찾기 {

	static int R, C;
	static char[][] arr;

	// delta: 상, 상우, 우, 우하, 하, 하좌, 좌, 상좌
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if(R == 0 && C == 0) break;

			arr = new char[R][C];

			for(int i = 0; i < R; i++)
				arr[i] = br.readLine().toCharArray();

			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {

					if(arr[r][c] == '*') continue;
					
					int cnt = 0;

					for(int d = 0; d < 8; d++) {
						
						int nr = r + dx[d];
						int nc = c + dy[d];
						
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || arr[nr][nc] != '*') continue;
						
						cnt++;
					}
					arr[r][c] = (char)(cnt + '0');
				}		
			}
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
			sb.setLength(0);
		}
	}
}
