package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시뮬레이션

public class BJ_14503_로봇청소기 {

	static int N, M, cnt;				// 배열 크기, 청소한 칸의 개수(=결과)
	static int[][] map;					// 
	static boolean[][] visited;			// 방문 검사 배열(이미 방문했던 칸은 다시 청소하지 않는다.)
	static Robot robot;					// 청소기 정보(r, c, d)
	static int[] dr = {-1, 0, 1, 0};	// delta: 상우하
	static int[] dc = {0, 1, 0, -1};
	static class Robot {
		int r, c, d;
		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// map 크기 입력
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());	// 청소기 정보 입력
		int robotR = Integer.parseInt(st.nextToken());
		int robotC = Integer.parseInt(st.nextToken());
		int robotD = Integer.parseInt(st.nextToken());
		robot = new Robot(robotR, robotC, robotD);
		
		map = new int[N][M];	// 	map 정보 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 조건 1. 바로 이동하기 전에 시작하는 위치를 청소한 후 이동
		visited = new boolean[N][M];
		visited[robotR][robotC] = true;
		cnt++;
		
		boolean isDone = false;	// 계속 청소를 할 것인지 아닌지 결정하는 변수
		while(!isDone) {
			isDone = cleaning();
		}
		
		
		System.out.print(cnt);
	}
	
	public static boolean cleaning() {
		int r = robot.r;
		int c = robot.c;
		int d = robot.d;
		
		// 4방향 검사
		for(int i = 0; i < 4; i++) {
			d = d > 0 ? d-1 : 3;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// map의 범위 안에 존재, 벽인 아닌 칸, 방문한 적이 없는 칸
			// 조건 2-b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1 || visited[nr][nc]) continue;
			
			// 조건 2-a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
			visited[nr][nc] = true;	// 방문 표시
			robot.r = nr;			// 왼쪽으로 한칸 이동 후 청소
			robot.c = nc;
			robot.d = d;
			cnt++;					// 청소한 칸 개수 증가
			return false;
		}
		
		// 조건 2-c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
		r -= dr[d];
		c -= dc[d];
		if(r >= 0 && r < N && c >= 0 && c < M && map[r][c] != 1) {
			robot.r = r;
			robot.c = c;
			return false;
		}
		
		// 조건 2-d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		return true;
	}
}
