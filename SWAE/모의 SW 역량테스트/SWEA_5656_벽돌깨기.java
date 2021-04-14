// https://data-make.tistory.com/566


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_5656_벽돌깨기 {

	static int N, W, H, totalBricks, min;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<Integer> queue2 = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			min = Integer.MAX_VALUE;
			totalBricks = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] stage = new int[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					stage[i][j] = Integer.parseInt(st.nextToken());
					
					if(stage[i][j] != 0) totalBricks++;
				}
			}
			
			process(0, totalBricks, stage);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}		
		
		System.out.print(sb);
	}
	
	private static boolean process(int n, int total, int[][] stage) {
		// 기저1: 남은 벽돌이 없을 때
		if(total == 0) {
			min = 0;
			return true;
		}
		
		// 기저2: 남은 구슬이 없을 때
		if(n == N) {
			min = Math.min(min, total);
			return false;
		}
		
		int[][] stageT = new int[H][W];
		
		for(int c = 0; c < W; c++) {
			
			int r = 0;
			
			for(; r < H; ++r) {
				if(stage[r][c] != 0) break;
			}
			
			if(r == H) continue;	// 남은 벽돌이 없으면 다음 열로 넘어간다.
			
			// 배열 복사
			copyStage(stage, stageT);
			
			// 벽돌 깨기
			int breakCnt = breaking(r, c, stageT);
			
			// 벽돌 내리기
			falling(stageT);
			
			// true: 탐색 완료, false: 다음 구슬 탐색
			if(process(n+1, total-breakCnt, stageT)) return true;
		}

		return false;
	}
	
	private static void falling(int[][] stageT) {
        for (int c = 0; c < W; c++) {
            
        	for(int r = H-1; r >= 0; r--) {
        		if(stageT[r][c] > 0) {
        			queue2.add(stageT[r][c]);
        		}
        		stageT[r][c] = 0;
        	}
        	
        	int r = H-1;
        	
        	while(!queue2.isEmpty()) {
        		stageT[r--][c] = queue2.poll();
        	}
        }
	}
	
	private static int breaking(int r, int c, int[][] stageT) {
		
		int cnt = 0;
		
		if(stageT[r][c] > 1) queue.add(new int[] {r, c, stageT[r][c]});
		stageT[r][c] = 0;
		
		cnt++;
		
		while(!queue.isEmpty()) {
			int[] brick = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = brick[0];
				int nc = brick[1];
				
				for(int b = 0; b < brick[2]-1; b++) {
					nr += dr[d];
					nc += dc[d];
					
					if(nr < 0 || nr >= H || nc < 0 || nc >= W || stageT[nr][nc] == 0) continue;
					
					if(stageT[nr][nc] > 1) queue.add(new int[] {nr, nc, stageT[nr][nc]});
					stageT[nr][nc] = 0;
					
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	
	private static void copyStage(int[][] stage, int[][] stageT) {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				stageT[i][j] = stage[i][j];
			}
		}
	}
}
