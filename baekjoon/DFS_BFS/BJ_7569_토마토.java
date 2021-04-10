
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_7569_토마토 {

	// 행: N, 열: M, 상자의 개수: H, 익지 않은 토마토 개수
	static int M, N, H, unripeTotal;	
	static int[][][] box;
	static int[] tmt;
	static Queue<int[]> ripeQ = new LinkedList<>();
	
	// 상, 우, 하, 좌, 윗, 아
	static int[][] delta = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {-1, 0, 0}, {1, 0, 0}};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					int input = Integer.parseInt(st.nextToken());
					if(input == 1) ripeQ.add(new int[] {h, i, j, 0});	// 익은 토마도 큐에 담기
					else if(input == 0) unripeTotal++;	// 안익은 토마토 수
					box[h][i][j] = input;
				}
			}
		}
		
		if(unripeTotal == 0) System.out.println(0);	// 처음부터 다 익었을 때
		else {
			bfs();	// 익히기
			if(unripeTotal == 0) System.out.println(tmt[3]);	// 안 익은 토마도가 없다면, 마지막으로 익은 토마도의 일 수 가져와서 출력
			else System.out.println(-1);
		}
	}
	
	private static void bfs() {
		
		while(!ripeQ.isEmpty()) {
			
			tmt = ripeQ.poll();
			
			for(int d = 0; d < 6; d++) {
				int nh = tmt[0] + delta[d][0];
				int nr = tmt[1] + delta[d][1];
				int nc = tmt[2] + delta[d][2];
				
				if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M || box[nh][nr][nc] != 0) continue;
				
				unripeTotal--;	// 하나 익음
				
				box[nh][nr][nc] = 1;	// 익음 표시
				
				ripeQ.add(new int[] {nh, nr, nc, tmt[3]+1});	// 하루 증가해서 큐에 삽입
			}
		}
	}
}
