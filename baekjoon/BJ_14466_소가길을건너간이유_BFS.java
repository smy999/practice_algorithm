// https://skygood95.tistory.com/38
// https://suhyeokeee.tistory.com/208#recentEntries

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_14466_소가길을건너간이유 {

	static int N, K, R, pairCnt;
	static int[][] cow;
	static ArrayList<Grassland>[][] load;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Grassland{
		int r, c;
		public Grassland(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		load = new ArrayList[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				load[i][j] = new ArrayList<>();
			}
		}
		
		// 길 정보
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			load[r1][c1].add(new Grassland(r2, c2));
			load[r2][c2].add(new Grassland(r1, c1));
		}
		
		// 소 정보
		cow = new int[N+1][N+1];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cow[r][c] = 1;
		}
		
		// 소가 있는 위치에서만 dfs 실행
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				// 오류: cow[i][j] == 1를 확인하지 않고 바로 dfs 호출
				if(cow[i][j] == 1) bfs(i, j);	
			}
		}
		
		// 한 쌍이기 때문에 2로 나눠준다.
		System.out.print(pairCnt/2);
	}
	
	private static void bfs(int r, int c) {
		boolean[][] visited = new boolean[N+1][N+1];
		Queue<Grassland> queue = new LinkedList<>();
		
		queue.offer(new Grassland(r, c));
		visited[r][c] = true;
		            
		// 자기자신도 포함하기 때문에
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			Grassland grass = queue.poll();
			
			// 길을 만나지 않고 소를 만나면 결과에서 제외
			if(cow[grass.r][grass.c] == 1) { 
				cnt++;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = grass.r + dr[d];
				int nc = grass.c + dc[d];
				
				// 해당 위치에 길이 있는지 확인하는 flag
				boolean hasLoad = false;
				
				// 범위 및 방문 검사
				if(nr < 1 || nr > N || nc < 1 || nc > N || visited[nr][nc]) continue;
				
				// 현재 갈 수 있는 곳에서 길이 있다면 queue에 추가하지 않는다.
				for(Grassland tmp : load[grass.r][grass.c]) {
					if(tmp.r == nr && tmp.c == nc) {
						hasLoad = true;
						break;
					}
				}
				
				if(!hasLoad) {
					queue.offer(new Grassland(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		
		pairCnt += (K - cnt);
	}
}
