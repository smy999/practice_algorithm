package 재귀;

import java.io.*;
import java.util.Arrays;

public class BJ_2447_별_찍기10 {

	static int N;
	static char[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		star = new char[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(star[i], ' ');
		}

		starPrint(0, 0, N);

		for(int i = 0; i < N; i++) {
			System.out.println(star[i]);
		}

	}

	static void starPrint(int i, int j, int N) {

		if(N == 1) {
			star[i][j] = '*';
			return;
		}

		int n = N/3;

		for( int i2 = 0; i2 < 3; i2++) {

			for( int j2 = 0; j2 < 3; j2++) {

				if(i2 == 1 && j2 == 1)
					continue;
				starPrint(i+(n*i2), j+(n*j2), n);
			}
		}

	}
}
