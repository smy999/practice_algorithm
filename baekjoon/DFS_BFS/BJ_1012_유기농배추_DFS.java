import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_1012_유기농배추_DFS {
	static int T, M, N, K, x, y, cnt;
	static boolean[][] land;
	static boolean[][] visited;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			land = new boolean[M][N];
			visited = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				land[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (land[i][j] && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];

			if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] || !land[nr][nc])
				continue;
			
			dfs(nr, nc);
		}
	}
}
