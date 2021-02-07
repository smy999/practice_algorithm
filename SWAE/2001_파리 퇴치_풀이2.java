import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치 {
	
	static int T, N, M, max, range, sum;
	static int[][] fly;
	static StringTokenizer  st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_2001.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			fly = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			sum = 0;
			range = N-M;
			for(int i = 0; i <= range; i++) {
				for(int j = 0; j <= range; j++) {
					sum = flySum(i, j);
					if(sum > max) max = sum;
				}
			}
			System.out.println("#" + t + " " + max);
		}
		
	}
	
	static int flySum(int i, int j) {
		int sum = 0;
		
		for(int i2 = i; i2 < i + M; i2++) {
			for(int j2 = j; j2 < j + M; j2++) {
				sum += fly[i2][j2];
			}
		}
		
		return sum;
	}
}
