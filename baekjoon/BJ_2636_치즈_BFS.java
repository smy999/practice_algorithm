

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class BJ_2636_치즈 {

	static int R, C, preCnt, time;
	
	static int[][] cheese;
	
	static boolean[][] visitAir;
	static boolean[][] visitHole;
	
	static Queue<int[]> air = new LinkedList<>();
	static Queue<int[]> hole = new LinkedList<>();
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cheese = new int[R][C];
		visitAir = new boolean[R][C];
		visitHole = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visitAir[0][0] = true;
		air.add(new int[] {0, 0});
		
		while (true) {
			
			find();
			if(hole.isEmpty()) break;	
			melt();	
			time++;
		}

		System.out.print(time + "\n" + preCnt);

	} // func: main

	
	private static void melt() {
		preCnt = hole.size();
		while(!hole.isEmpty()) {
			int[] h = hole.poll();
			cheese[h[0]][h[1]] = 0;
			air.add(new int[] {h[0], h[1]});
		}
	} // func: melt

	
	private static void find() {
		while (!air.isEmpty()) {
			int[] a = air.poll();

			for (int d = 0; d < 4; d++) {
				int nr = a[0] + dr[d];
				int nc = a[1] + dc[d];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visitAir[nr][nc])
					continue;

				if(cheese[nr][nc] == 0) {
					visitAir[nr][nc] = true;
					air.add(new int[] {nr, nc});
				}
				
				else if(cheese[nr][nc] == 1) {
					if(visitHole[nr][nc]) continue;
					visitHole[nr][nc] = true;
					hole.add(new int[] {nr, nc});
				}
			} // for	
			
		} // while
		
	} // func: find
	
}

