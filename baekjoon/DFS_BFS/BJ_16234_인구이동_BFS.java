package Oct_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구이동 {

	static int N, L, R, ans;
	static int[][] A;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 땅의 크기
		L = Integer.parseInt(st.nextToken());	// 최소 인구 수 차이
		R = Integer.parseInt(st.nextToken());	// 최대 인구 수 차이
		
		A = new int[N][N];	// 국가별 인구 수 저장 배열
		
		// 입력
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 인구 이동 시작
		move();
		
		// 결과 출력
		System.out.print(ans);
	}
	
	public static void move() {
		while(true) {
			boolean flag = false;
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					if(bfs(i, j)) flag = true;	// 인접한 국가가 있으면 이동일을 구하기 위해 flag를 true로 변경
				}
			}
			
			if(flag) ans++;
			else return;
		}
	}
	
	public static boolean bfs(int r, int c) {
		boolean isConnect = false;	// 인접한 국가가 있으면 true, 아니면 false.
		
		int cnt = 1;		// 인접한 국가의 수
		int sum = A[r][c];	// 인접한 국가의 인구 총 합
		
		// 첫 번째 국가 미리 넣어주기
		List<int[]> list = new ArrayList<>();
		list.add(new int[] {r, c});
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		visited[r][c] = true;	// 방문 처
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				
				int diff = Math.abs(A[nr][nc] - A[pos[0]][pos[1]]);
				
				// 인구 이동이 일어날 조건
				if(diff >= L && diff <= R) {
					cnt++;
					sum += A[nr][nc];
					
					visited[nr][nc] = true;
					
					list.add(new int[] {nr, nc});
					queue.add(new int[] {nr, nc});
				}
			}
		}
		
		// 인접한 국가가 있으면 인접한 모든 국가의 인구수를 인접인구합/인접국가수(=평균)으로 변경한다.
		if(list.size() > 1) {
			isConnect = true;
			int avg = sum/cnt;
			for(int[] pos : list) A[pos[0]][pos[1]] = avg;
		}
		
		// 입접한 국가가 있는지 없는지 판단하여 반환
		return isConnect;
	}
}
