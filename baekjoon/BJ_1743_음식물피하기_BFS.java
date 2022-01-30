package Feb_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_1743_음식물피하기_BFS {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int max = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (visited[i][j] || map[i][j] == 0)
					continue;

				Queue<int[]> queue = new LinkedList<>();
				queue.add(new int[] { i, j });
				visited[i][j] = true;

				int cnt = 1;

				while (!queue.isEmpty()) {
					int[] cur = queue.poll();

					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];

						if (nr < 1 || nr > N || nc < 1 || nc > M || visited[nr][nc] || map[nr][nc] == 0)
							continue;

						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
						cnt++;
					}
				}

				max = Math.max(max, cnt);

			}
		}

		System.out.print(max);
	}
}
