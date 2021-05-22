import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class BJ_2583_영역구하기 {
	
	static int M, N, K;
	static int[][] grid;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<Integer> areaList = new ArrayList<Integer>();
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		grid = new int[M][N];
		
		// 직사각형은 1로 표기
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			
			for(int i = startC; i < endC; i++) {
				for(int j = startR; j < endR; j++) {
					grid[i][j] = 1;
				}
			}
		}
		
		// 직사각형을 제외한 부분들 bfs 탐색
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		
		// 오름차순으로 정렬
		Collections.sort(areaList);
		
		StringBuilder sb = new StringBuilder();
		sb.append(areaList.size()).append("\n");
		for(int num : areaList) {
			sb.append(num).append(" ");
		}
		
		System.out.print(sb);
	}
	
	private static void bfs(int r, int c) {
		// queue 생성
		queue = new LinkedList<>();
		// 초기 설정
		queue.offer(new int[] {r, c});
		grid[r][c] = 1;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = info[0] + dr[d];
				int nc = info[1] + dc[d];
				
				// 직사각형이 아닌 부분들만 & 범위
				if(nr < 0 || nr >= M || nc < 0 || nc >= N || grid[nr][nc] != 0) continue;
				
				cnt++; // 영역 크기 갱신
				grid[nr][nc] = 1;	// 확인한 부분 1로 설정
				queue.offer(new int[] {nr, nc});	// 탐색할 부분 queue에 추가
			}
		}

		areaList.add(cnt);	// 결과 넣어주기
	}

}
