
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_16985_Maaaaaaaaaze {

	static int min = Integer.MAX_VALUE;
	
	static int[][][] maze = new int[5][5][5];
	static int[][][] mazeT = new int[5][5][5];
	
	static int[] npPerm = {0, 1, 2, 3, 4};
	
	static Queue<Location> loc;
	
	static boolean[][][] visited;
	
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static int[] dy = {-1, 0, 1, 0, 0, 0};
	static int[] dx = {0, 1, 0, -1, 0, 0};
	
	static class Location {
		int z, y, x, d;
		public Location(int z, int y, int x, int d) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int k = 0; k < 5; k++) {
			for(int i = 0; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 5; j++) {
					maze[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// 1. 순열
		// 순열인데, 경우의 수 하나마다 연산하고 싶다. => Next Permutation
		while(true) {
			
			// 2. 회전: 90도씩 회전하며 모든 경우의 수 시도
			makeMaze();
			
			if(min == 12) break;
			
			if(!np()) break;
		}
		
		System.out.print(min);
	}
	
	private static void makeMaze() {
		for(int i = 0; i < 5; i++) 
			System.arraycopy(maze[npPerm[i]], 0, mazeT[i], 0, 5);
		
		for(int a = 0; a < 4; a++) {
			rotate(0);
			
			if(mazeT[0][0][0] == 0) continue;
			
			for(int b = 0; b < 4; b++) {
				rotate(1);
				for(int c = 0; c < 4; c++) {
					rotate(2);
					for(int d = 0; d < 4; d++) {
						rotate(3);
						for(int e = 0; e < 4; e++) {
							rotate(4);
							
							if(mazeT[4][4][4] == 0) continue;
							
							// 3. BFS: 최소 경로 찾기
							min = Math.min(min, bfs());
							if(min == 12) return;
						}
					}
				}
			}
		}
	}
	
	private static int bfs() {
		loc = new LinkedList<Location>();	
		loc.add(new Location(0, 0, 0, 0));
		
		visited = new boolean[5][5][5];
		visited[0][0][0] = true;
		
		while(!loc.isEmpty()) {
			Location l = loc.poll();
			
			if(l.z == 4 && l.y == 4 && l.x == 4) return l.d;
			if(l.d >= min) return Integer.MAX_VALUE;
			
			for(int d = 0; d < 6; d++) {
				int nz = l.z + dz[d];
				int ny = l.y + dy[d];
				int nx = l.x + dx[d];
				
				if(nz < 0 || nz >= 5 || ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || visited[nz][ny][nx] || mazeT[nz][ny][nx] == 0) continue;
				
				visited[nz][ny][nx] = true;
				
				loc.add(new Location(nz, ny, nx, l.d+1));
				
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private static void rotate(int k) {
		int[][] temp = new int[5][5];
		
		// 3 차원 배열 복사 주의하기
		for(int i = 0; i < 5; i++) {
			System.arraycopy(mazeT[k][i], 0, temp[i], 0, 5);
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				mazeT[k][i][j] = temp[4-j][i];
			}
		}
	}
	
	private static boolean np() {
		int i = 4;
		while(i > 0 && npPerm[i-1] >= npPerm[i]) i--;
		
		if(i == 0) return false;
		
		int j = 4;
		while(npPerm[i-1] >= npPerm[j]) j--;
		
		swap(i-1, j);
		
		int k = 4;
		while(i < k) swap(i++, k--);
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int tmp = npPerm[i];
		npPerm[i] = npPerm[j];
		npPerm[j] = tmp;
	}
}
