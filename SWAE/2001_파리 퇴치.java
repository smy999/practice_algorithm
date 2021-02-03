package hwalgo03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2001_파리 퇴치

public class SWEA_2001 {
	
	static int T, N, M, kill, range, MAX=Integer.MIN_VALUE;
	static int[][] fly;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			fly = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int MAX = 0;
			for(int i = 0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					kill = 0;
					for(int i2 = i; i2 < i+M; i2++) {
						for(int j2 = j; j2 < j+M; j2++) {
							kill += fly[i2][j2];
						}
					}
					if(kill > MAX) MAX = kill;
				}
			}
			
			System.out.println("#" + t + " " + MAX);
		}
	}
}
