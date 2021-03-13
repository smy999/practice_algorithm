package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class SWEA_10966_물놀이를가자 {
	static int N, M, cnt, ans;
	static String str;
	static char[][] pool;
	static int[][] move;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_10966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			move = new int[N][M];

			for (int i = 0; i < N; i++) {
				// pool[i] = br.readLine().toCharArray();
				str = br.readLine();
				for (int j = 0; j < M; j++) {
					// if(pool[i][j] == 'W') {
					if (str.charAt(j) == 'W') {
						move[i][j] = 1;
						queue.add(new int[] { i, j });
					}
				}
			}
			
			cnt = queue.size();
					
			while (!queue.isEmpty()) {
				int[] tmp = queue.poll();
				for(int d = 0; d < 4; d++) {
					int nr = tmp[0] + dr[d];
					int nc = tmp[1] + dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >=M || move[nr][nc] != 0) continue;
					
					move[nr][nc] = move[tmp[0]][tmp[1]] + 1;
					queue.add(new int[] {nr, nc});
				}
			}
			
			// 확인 출력
//			for(int[] m : move)
//				System.out.println(Arrays.toString(m));
			
			ans = 0;
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < M; j++)
					ans += move[i][j];
			
			// 'W'일 때 1 부터 시작했으므로 모든 거리가 1만큼 크다. 따라서 배열안 원소의 크기만큼 빼준다.
			System.out.println("#" + t + " " + (ans-N*M));
		}
	}
}
