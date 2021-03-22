import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1227_미로2_BFS {

	static int startR, startC, endR, endC;
	static int[][] maze;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1227.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			maze = new int[100][100];
			visited = new boolean[100][100];
			
			for(int i = 0; i < 100; i++) {
				String str = br.readLine();
				for(int j = 0; j < 100; j++) {
					int num = str.charAt(j) - '0';
					maze[i][j] = num;
					if(num == 2) {
						startR = i;
						startC = j;
					}
				}
			}
			System.out.println("#" + t + " " + bfs());
		}
	}
	
	private static int bfs() {
		queue = new LinkedList<>();
		queue.add(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if(nr < 0 || nr >= 100 || nc < 0 || nc >= 100 
						|| maze[nr][nc] == 1 || visited[nr][nc]) continue;
				
				if(maze[nr][nc] == 3) return 1;
				queue.add(new int[] {nr, nc});
				visited[temp[0]][temp[1]] = true;
			}
		}
		return 0;
	}
}
