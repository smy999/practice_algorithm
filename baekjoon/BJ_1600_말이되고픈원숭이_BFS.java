

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_1600_말이되고픈원숭이 {

	static int K, W, H, cnt;
	static int[][] world, move; // 입력 배열

	static boolean[][][] visited;

	static Queue<Info> queue = new LinkedList<>();

	// 말: 8방 (상좌, 상우, 우상, 우하, 하우, 하좌, 좌하, 좌상)
	static int[] hr = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] hc = { -1, 1, 2, 2, 1, -1, -2, -2 };

	// 원숭이: 4방 (상, 우, 하, 좌)
	static int[] mr = { -1, 0, 1, 0 };
	static int[] mc = { 0, 1, 0, -1 };

	static class Info {
		int r, c, k, cnt;

		public Info(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	} // Info class

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		world = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				world[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		queue.add(new Info(0, 0, K, 0));

		bfs();

		System.out.print(cnt);
		
	} // func: main

	private static void bfs() {
		while (!queue.isEmpty()) {
			Info q = queue.poll();

			if (q.r == H - 1 && q.c == W - 1) {
				cnt = q.cnt;
				return; // 도착지 값 구해지면 반환
			} 

			for (int d = 0; d < 4; d++) {
				int nr = q.r + mr[d];
				int nc = q.c + mc[d];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc][q.k] || world[nr][nc] == 1) continue;

				visited[nr][nc][q.k] = true;
				queue.add(new Info(nr, nc, q.k, q.cnt + 1));
			} // for: 4방

			if (q.k == 0) continue;

			for (int d = 0; d < 8; d++) {
				int nr = q.r + hr[d];
				int nc = q.c + hc[d];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc][q.k - 1] || world[nr][nc] == 1) continue;

				visited[nr][nc][q.k - 1] = true;
				queue.add(new Info(nr, nc, q.k - 1, q.cnt + 1));
			} // for: 8방
			
		} // while
		
		cnt = -1;
	
	} // func: dfs

}
