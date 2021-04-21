package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BJ_15683_감시_sol {

	static int N, M, min;
	static int[][] map;
	static ArrayList<Cam> list = new ArrayList<>();
	
	static class Cam {
		int y, x, n;
		public Cam(int y, int x, int n) {
			this.y = y;
			this.x = x;
			this.n = n;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		//visited = new boolean[N][M][4];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			 for(int j = 0; j < M; j++) {
				 int cctvNo = Integer.parseInt(st.nextToken());
				 map[i][j] = cctvNo;
				 if(cctvNo != 0 && cctvNo != 6) list.add(new Cam(i, j, cctvNo));
			 }
		}

		min = Integer.MAX_VALUE;
		dfs(0, map);	// 매개변수: 1. list index, 2. 원본 배열 
		System.out.print(min);
	}
	

	private static void dfs(int idx, int[][] parent) {
		// 기저조건
		if(idx == list.size()) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(parent[i][j] == 0) cnt++;
				}
			}
			min = Math.min(min, cnt);
			return;
		}
		
		Cam c = list.get(idx);
		switch(c.n) {
		case 1 : 
			for(int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				check(c.y, c.x, d, child);
				dfs(idx+1, child);
			}
			break;
		case 2 : 
			for(int d = 0; d < 2; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				check(c.y, c.x, d, child);
				check(c.y, c.x, d+2, child);
				dfs(idx+1, child);
			}
			break;
		case 3 : 
			for(int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				check(c.y, c.x, d, child);
				check(c.y, c.x, (d+1)%4, child);
				dfs(idx+1, child);
			}
			break;
		case 4 : 
			for(int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				check(c.y, c.x, d, child);
				check(c.y, c.x, (d+1)%4, child);
				check(c.y, c.x, (d+2)%4, child);
				dfs(idx+1, child);
			}
			break;
		case 5 : 
			int[][] child = copyMap(parent);
			// 비추는 작업
			for(int d = 0; d < 4; d++) {
				check(c.y, c.x, d, child);
			}
			dfs(idx+1, child);
			break;
		}
	}
	
	private static void check(int y, int x, int dir, int[][] last) {
		// dir 0: 좌, 1: 상, 2: 우, 3: 하 
		// 한쪽 방향으로 검사
		switch(dir) {
		case 0: // 좌
			for(int i = x; i >= 0; i--) {
				if(last[y][i] == 6) break;
				last[y][i] = 9;
			}
			break;
		case 1: // 상
			for(int i = y; i >= 0; i--) {
				if(last[i][x] == 6) break;
				last[i][x] = 9;
			}
			break;
		case 2: // 우
			for(int i = x; i < M; i++) {
				if(last[y][i] == 6) break;
				last[y][i] = 9;
			}
			break;
		case 3: // 하
			for(int i = y; i < N; i++) {
				if(last[i][x] == 6) break;
				last[i][x] = 9;
			}
			break;
		}
	}
	
	private static int[][] copyMap(int[][] origin) {
		int [][] copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
}
