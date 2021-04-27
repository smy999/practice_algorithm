import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class BJ_20056_마법사상어와파이어볼 {

	static int N, M, K;
	static LinkedList<FireBall>[][] grid;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static class FireBall {
		int m, s, d;
		public FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		grid = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				grid[i][j] = new LinkedList<FireBall>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			grid[r][c].add(new FireBall(m, s, d));
		}
		
		for(int k = 0; k < K; k++) {
			// 모든 파이어볼 이동
			move();
			// 같은 위치 파이어볼 합치고 나누기
			mergeAndDivide();
		}
		
		System.out.print(getTotalMass());
	}
	
	private static void move() {
		LinkedList<FireBall>[][] newGrid = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				newGrid[i][j] = new LinkedList<FireBall>();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j].size() >= 1) {
					for(FireBall ball : grid[i][j]) {
						
						int speed = ball.s%N;
						int dir = ball.d;
						
						int nr = i + dr[dir]*speed;
						int nc = j + dc[dir]*speed;
						
						if(nr < 0) nr += N;
						else if(nr >= N) nr -= N;
						if(nc < 0) nc += N;
						else if(nc >= N) nc -= N;
						
						newGrid[nr][nc].add(ball);
					}
				} // if
			} // for:j
		} // for:i
		
		grid = newGrid;
	}
	
	private static void mergeAndDivide() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int size = grid[i][j].size();
				if(size > 1) {
					// 합치기
					int mass = 0;
					int speed = 0;
					boolean isEven = true;
					boolean isOdd = true;
					for(FireBall ball : grid[i][j]) {
						mass += ball.m;
						speed += ball.s;
						int dir = ball.d;
						if(dir%2 != 0) isEven = false;
						else isOdd = false;
					}
					// 나누기
					grid[i][j].clear();
					mass /= 5;
					if(mass == 0) continue;
					speed /= size;
					int dir = 0;
					if(!isEven && !isOdd) dir = 1;
					for(int b = 0; b < 4; b++, dir+=2) {
						grid[i][j].add(new FireBall(mass, speed, dir));
					}
				}
			}
		}
	}

	private static int getTotalMass() {
		int totalMass = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(FireBall ball : grid[i][j]) totalMass += ball.m;
			}
		}
		return totalMass;
	}
}
