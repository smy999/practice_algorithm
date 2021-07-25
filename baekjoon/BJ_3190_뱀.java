package July_week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class BJ_3190_뱀 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int curR = 1, curC = 1, cnt = 0, dir = 1;
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] apple = new boolean[N+1][N+1];
		boolean[][] snake = new boolean[N+1][N+1];
		
		int K = Integer.parseInt(br.readLine());
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			apple[r][c] = true;
		}

		int L = Integer.parseInt(br.readLine());
		int[] S = new int[L];
		char[] D = new char[L];	
		for(int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			S[l] = Integer.parseInt(st.nextToken());
			D[l] = st.nextToken().charAt(0);
		}
		
		List<int[]> list = new LinkedList<>();
		list.add(new int[] {1, 1});
		snake[1][1] = true;
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		boolean isBreak = false;
		for(int l = 0; l < L; l++) {
			isBreak = false;
			while(cnt < S[l]) {
				cnt++;
				
				int nr = curR + dr[dir];
				int nc = curC + dc[dir];
				
				if(nr < 1 || nr > N || nc < 1 || nc > N || snake[nr][nc]) {
					isBreak = true;
					break;
				}
				
				list.add(new int[] {nr, nc});
				snake[nr][nc] = true;
				
				if(apple[nr][nc]) {
					apple[nr][nc] = false;
				} else {
					int[] temp = list.remove(0);
					snake[temp[0]][temp[1]] = false;
				}
				
				curR = nr; curC = nc;

			}
			
			if(isBreak) break;
			
			if(D[l] == 'D') {
				dir++;
				if(dir == 4) dir = 0;
			} else {
				dir--;
				if(dir == -1) dir = 3;
			}
		}
		
		if(!isBreak) {
			while(true) {
				cnt++;
				
				int nr = curR + dr[dir];
				int nc = curC + dc[dir];
				
				if(nr < 1 || nr > N || nc < 1 || nc > N || snake[nr][nc]) {
					isBreak = true;
					break;
				}
				
				list.add(new int[] {nr, nc});
				snake[nr][nc] = true;
				
				if(apple[nr][nc]) {
					apple[nr][nc] = false;
				} else {
					int[] temp = list.remove(0);
					snake[temp[0]][temp[1]] = false;
				}
				
				curR = nr; curC = nc;

			}
		}
		
		System.out.print(cnt);
	}

}
