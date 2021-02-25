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
		area = new int[N][2];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			area[i][0] = Integer.parseInt(st.nextToken());
			area[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			if(D + area[i][0] == 3) {
				sum += (int)Math.min(area[i][1]+B, 2*C-B-area[i][1]);
			} else if(D + area[i][0] == 7) {
				sum += (int)Math.min(area[i][1]+B, 2*R-B-area[i][1]);
			} else {
				sum += B + area[i][1];
			}
		}
		
		System.out.print(sum);
	}
}
