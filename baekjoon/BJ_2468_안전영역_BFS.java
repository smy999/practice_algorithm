
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Iterator;

public class BJ_2468_안전영역 {

	static int N, max= Integer.MIN_VALUE, cnt;
	static int[][] area;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static HashSet<Integer> set = new HashSet<Integer>();
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		
		set.add(0);	// 모두 잠기지 않을 가능성
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int hight = Integer.parseInt(st.nextToken());
				area[i][j] = hight;
				set.add(hight);
			}
		}
		
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			
			visited = new boolean[N][N];
			
			cnt = 0;
			
			int h = (int)iter.next();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(h < area[i][j] && !visited[i][j]) {
						bfs(i, j, h);
						cnt++;
					}
				}
			}
			
			max = Math.max(max, cnt);
		}
		
		System.out.print(max);
	}
	
	private static void bfs(int r, int c, int h) {
		
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] safe = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = safe[0] + dr[d];
				int nc = safe[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N 
						|| visited[nr][nc] || area[nr][nc] <= h) continue;
				
				visited[nr][nc] = true;
				queue.add(new int[] {nr, nc});
			}
		}
	}
}
