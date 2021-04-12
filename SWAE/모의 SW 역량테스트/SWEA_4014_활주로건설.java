package Youtube;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {

	static int N, X, totalAirstrip;
	static boolean installable;
	static int[][] cliffs;
	static boolean[][] installed;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			totalAirstrip = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			cliffs = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cliffs[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 좌 >> 우 -------------------------------------------------------------------------
			
			installed = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {

				installable = true;

				for (int j = 1; j < N; j++) {
					
					// 1. 높이가 같을 때
					if (cliffs[i][j] == cliffs[i][j-1]) continue;
					
					// 2. 앞이 뒤보다 클 때
					if(cliffs[i][j-1] - cliffs[i][j] == 1) {
						
						// 경사로를 놓을 만큼의 길이(X)가 있는지 확인
						if (j+X-1 >= N) {	
							installable = false;
							break;
						}
						
						// 경사로를 놓을 자리들의 높이가 모두 같은가? 설치 이력이 있는가?
						for (int x = j; x < j + X; x++) {
							if (installed[i][x] || cliffs[i][j] != cliffs[i][x]) {
								installable = false;
								break;
							}
						}
						
						if (!installable) break;

						for (int x = j; x < j + X; x++) installed[i][x] = true;
					}
					
					// 3. 뒤가 앞보다 클 때
					else if (cliffs[i][j] - cliffs[i][j-1] == 1) {
						
						// 경사로를 놓을 만큼의 길이(X)가 있는지 확인
						if (j-X < 0) {	
							installable = false;
							break;
						}
						
						// 경사로를 놓을 자리들의 높이가 모두 같은가? 설치 이력이 있는가?
						for (int x = j-X; x < j; x++) {
							if (installed[i][x] || cliffs[i][j-1] != cliffs[i][x]) {
								installable = false;
								break;
							}
						}

						if (!installable) break;

						for(int x = j-X; x < j; x++) installed[i][x] = true;
					}
					
					// 4. 높이가 2이상 차이날 때
					else {
						installable = false;
						break;
					}

				}
				
				if (installable) totalAirstrip++;
			}

			// 상 >> 하  -------------------------------------------------------------------------
			
			installed = new boolean[N][N];
			
			for (int j = 0; j < N; j++) {
				
				installable = true;

				for (int i = 1; i < N; i++) {
					
					// 1. 높이가 같을 때
					if (cliffs[i][j] == cliffs[i-1][j]) {
						continue;
					}

					// 2. 앞이 뒤보다 클 때
					if (cliffs[i-1][j] - cliffs[i][j] == 1) {
						
						if (i+X-1 >= N) {	// 경사로를 놓을 만큼의 길이(X)가 있는지 확인
							installable = false;
							break;
						}

						// 경사로를 놓을 자리들의 높이가 모두 같은가? 설치 이력이 있는가?
						for (int x = i; x < i + X; x++) {
							if (installed[x][j] || cliffs[i][j] != cliffs[x][j]) {
								installable = false;
								break;
							}
						}
						
						if (!installable) break;

						for (int x = i; x < i + X; x++) installed[x][j] = true;

					}

					// 3. 뒤가 앞보다 클 때
					else if (cliffs[i][j] - cliffs[i-1][j] == 1) {

						if (i-X < 0) {	// 경사로를 놓을 만큼의 길이(X)가 있는지 확인
							installable = false;
							break;
						}
						
						// 경사로를 놓을 자리들의 높이가 모두 같은가? 설치 이력이 있는가?
						for (int x = i-X; x < i; x++) {
							if (installed[x][j] || cliffs[i-1][j] != cliffs[x][j]) {
								installable = false;
								break;
							}
						}

						if (!installable) break;

						for (int x = i-X; x < i; x++) installed[x][j] = true;
					
					}

					// 4. 높이가 2이상 차이날 때
					else {
						installable = false;
						break;
					}

				}
				
				if (installable) totalAirstrip++;
				
			} // 상 >> 하
			
			sb.append("#").append(t).append(" ").append(totalAirstrip).append("\n");
			
		}	// for T
		
		System.out.println(sb);
		
	} 	// main
} // class
