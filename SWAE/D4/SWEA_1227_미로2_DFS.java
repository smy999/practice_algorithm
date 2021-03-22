import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1227_미로2_DFS {

	static int N = 100, startR, startC, endR, endC;
	static boolean flag;
	static int[][] maze;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1227.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			flag = false;

			int tc = Integer.parseInt(br.readLine());

			maze = new int[100][100];
			visited = new boolean[100][100];

			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					int num = str.charAt(j) - '0';
					maze[i][j] = num;
					if (num == 2) {
						startR = i;
						startC = j;
					}
				}
			}
			
			dfs(startR, startC);

			if (flag) sb.append("#" + t + " " + 1 + "\n");
			else sb.append("#" + t + " " + 0 + "\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int r, int c) {
		if (flag) return;

		if (maze[r][c] == 3) {
			flag = true;
			return;
		}

		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100 || maze[nr][nc] == 1 || visited[nr][nc])
				continue;

			dfs(nr, nc);
		}
		
		visited[r][c] = false;
	}
}
