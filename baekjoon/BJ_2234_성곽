package Nov_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2234_성곽 {

	static int N, M, max = 0, cnt = 0, unionMax = 0;
	static int[][] castle;
	static int[][] roomN;
	static ArrayList<Integer> roomS = new ArrayList<>();
	static boolean[][] roomNB;
	static int dr[] = {0, -1, 0, 1};
	static int dc[] = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		castle = new int[M][N];
		roomN = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}		

		// BFS를 활용하여 방의 크기를 구한다.
		// 방 하나를 셀 때마다 방의 번호를 부여한다.
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(roomN[i][j] != 0) continue;
				cnt++;
				bfs_count(cnt, i, j);
			}
		}

		// 그 후, 다시 전체 배열을 탐색하면서 4방으로 인접한 방과의 크기 합을 구한다.
		roomNB = new boolean[cnt+1][cnt+1];
		find_neighbors();
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		sb.append(max).append("\n");
		sb.append(unionMax);
		System.out.print(sb);
	}
	
	public static void bfs_count(int n, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {r, c});
		roomN[r][c] = n;
		
		int size = 1;
		
		while(!queue.isEmpty()) {
			int info[] = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				if((castle[info[0]][info[1]] & (1<<d)) != 0) continue;
				
				int nr = info[0] + dr[d];
				int nc = info[1] + dc[d];
				
				if(roomN[nr][nc] != 0) continue;

				queue.add(new int[] {nr, nc});
				roomN[nr][nc] = n;
				
				size++;
			}
		}
		
		roomS.add(size);
		max = Math.max(max, size);
	}

	public static void find_neighbors() {
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
					
					int info = roomN[r][c];
					int infoN = roomN[nr][nc];
					
					if((info == infoN) || roomNB[info][infoN]) continue;
					
					roomNB[info][infoN] = roomNB[infoN][info] = true;
					
					unionMax = Math.max(unionMax, roomS.get(info-1)+roomS.get(infoN-1));
				}
			}
		}
	}
}
