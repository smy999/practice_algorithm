
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class BJ_17144_미세먼지안녕 {

	static int R, C, T, air1 = -1, air2 = -1, totalDust;	// 행, 열, 초
	static int[][] house;
	static Queue<Info> dustQ = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] wr1 = {0, -1, 0, 1};
	static int[] wr2 = {0, 1, 0, -1};
	static int[] wc = {1, 0, -1, 0};
	
	static class Info {
		int r, c, d;
		public Info(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		house = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == -1) {
					if(air1 == -1) {
						air1 = r;
						air2 = r+1;
					}
				}
				else if(input > 0) {
					dustQ.add(new Info(r, c, input));
					totalDust += input;
				}
				house[r][c] = input;
			}
		}
		
		for(int t = 0; t < T; t++) {
			diffusion();
			print();
			cleaning();
			print();
			findDust();
		}
		
		System.out.print(totalDust);
	}
	
	private static void diffusion() {
		while(!dustQ.isEmpty()) {
			Info dust = dustQ.poll();
			int amount = 0;
			int cnt = 0;
			for(int d = 0; d < 4; d++) {
				int nr = dust.r + dr[d];
				int nc = dust.c + dc[d];
				
				if(nr < 0 || nr >= R || nc < 0|| nc >= C || house[nr][nc] == -1) continue;
				
				cnt++;
				amount = dust.d/5;
				house[nr][nc] += amount;
			}
			house[dust.r][dust.c] -= amount*cnt;
		}
	}
	
	private static void cleaning() {
		
		int r = air1, c = 1;
		int nr = 0, nc = 0;
		int pre = house[air1][1];
		house[air1][1] = 0;
		int next = 0;
		boolean flag = false;
		
		for(int d = 0; d < 4; d++) {
			
			while(true) {
				nr = r + wr1[d];
				nc = c + wc[d];
				
				if(nr < 0 || nr >= R || nc < 0|| nc >= C) break;

				if(house[nr][nc] == -1) break;
				
				next = house[nr][nc];
				house[nr][nc] = pre;
				pre = next;
				
				r = nr;
				c = nc;
			}
		}
		
		r = air2; c = 1;
		nr = 0; nc = 0;
		pre = house[air2][1];
		house[air2][1] = 0;
		next = 0;
		
		for(int d = 0; d < 4; d++) {
			
			while(true) {
				nr = r + wr2[d];
				nc = c + wc[d];

				if(nr < 0 || nr >= R || nc < 0|| nc >= C) break;
				
				if(house[nr][nc] == -1) break;
				
				next = house[nr][nc];
				house[nr][nc] = pre;
				pre = next;
				
				r = nr;
				c = nc;
			}
		}
	}

	private static void findDust() {
		totalDust = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(house[r][c] > 0) {
					dustQ.add(new Info(r, c, house[r][c]));
					totalDust += house[r][c];
				}
			}
		}
	}

	private static void print() {
		for(int r = 0; r < R; r++) {
			System.out.println(Arrays.toString(house[r]));
		}
		System.out.println();
	}
}
