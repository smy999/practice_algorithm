package hwalgo14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_경비원 {

	static int R, C, N, D, B, min, sum;
	static int[][] area;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(br.readLine());
		area = new int[N+1][3];

		for(int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int r = 0, c = 0;
			switch(d) {
			case 1: r = 0; c = b; break;
			case 2: r = R; c = b; break;
			case 3: r = b; c = 0; break;
			case 4: r = b; c = C; break;
			}
			area[i][0] = r;
			area[i][1] = c;
			area[i][2] = d;
		}

		for(int i = 0; i < N; i++) {
			if(area[N][2] + area[i][2] == 3) {
				sum += (int)Math.min(area[N][1]+area[i][1]+R, 2*C-area[N][1]-area[i][1]+R);
			} else if(area[N][2] + area[i][2] == 7) {
				sum += (int)Math.min(area[N][0]+area[i][0]+C, 2*R-area[N][0]-area[i][0]+C);
			} else {
				sum += (int)Math.abs(area[N][0]-area[i][0])+(int)Math.abs(area[N][1]-area[i][1]);
			}
		}
		
		System.out.print(sum);
	}
}
