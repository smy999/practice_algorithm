package Jan_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3085_사탕게임 {

	static int N, max = 0;
	static boolean find;
	static char[][] candy;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		candy = new char[N][];
		
		// 입력
		for(int i = 0; i < N; i++) 
			candy[i] = br.readLine().toCharArray();
		
		// 주의: 바꾸지 않는 경우는 없다. 반드시 다른 두 사탕의 위치를 바꾼다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j+1 < N && candy[i][j] != candy[i][j+1]) {
					swap(i, j, i, j+1);
					findMax();
					swap(i, j, i, j+1);
				}
				
				if(max == N) {
					System.out.print(max);
					return;
				}
				
				if(j+1 < N && candy[j][i] != candy[j+1][i]) {
					swap(j, i, j+1, i);
					findMax();
					swap(j, i, j+1, i);
				}
				
				if(max == N) {
					System.out.print(max);
					return;
				}
			}
		}
		
		System.out.print(max);
		
	}
	
	public static void findMax() {
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			char last = candy[i][0];
			for(int j = 1; j < N; j++) {
				if(last == candy[i][j]) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					last = candy[i][j];
					cnt = 1;
				}
			}
			
			cnt = 1;
			last = candy[0][i];
			for(int j = 1; j < N; j++) {
				if(last == candy[j][i]) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					last = candy[j][i];
					cnt = 1;
				}
			}
		}
	}
	
	public static void swap(int i, int j, int i2, int j2) {
		char tmp = candy[i][j];
		candy[i][j] = candy[i2][j2];
		candy[i2][j2] = tmp;
	}
}
