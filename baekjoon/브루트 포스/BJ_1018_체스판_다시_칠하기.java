package 브루트포스;

import java.io.*;
import java.util.*;

public class BJ_1018_체스판_다시_칠하기 {

	static int min = Integer.MAX_VALUE;
	static StringTokenizer st;
	static char[][] input;
	static char[][] chess = new char[8][8];

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		input = new char[N][];

		String str1 = "WBWBWBWB";
		String str2 = "BWBWBWBW";

		for(int i = 0; i < 8; i++) {
			if(i%2==0) chess[i] = str1.toCharArray();
			else chess[i] = str2.toCharArray();
		}

		for(int i = 0; i < N; i++)
			input[i] = br.readLine().toCharArray();

		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				painting(i, j);
			}
		}
		
		System.out.print(min);
	}
	
	static void painting(int i, int j) {
		int cntWB = 0, cntBW = 0;
		
		for(int ci = 0; ci < 8; ci++) {
			for(int cj = 0; cj < 8; cj++) {
				if(chess[ci][cj] != input[i+ci][j+cj]) cntWB++;
				else cntBW++;
			}
		}
		
		if(cntWB < min) min = cntWB;
		if(cntBW < min) min = cntBW;
	}
}
