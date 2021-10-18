import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class BJ_10163_색종이 {
	
	public static void main(String[] args) throws Exception {
		
		// System.setIn(new FileInputStream("input_10163.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// Scanner sc = new Scanner(System.in);
		// int N = sc.nextInt();
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[101][101];
		int r, c, h, w;
		
		for(int n = 1; n <= N; n++) {
			
			st = new StringTokenizer(br.readLine());
			
//			c = sc.nextInt();
//			r = sc.nextInt();
//			w = sc.nextInt();
//			h = sc.nextInt();
			
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int i = c; i < c+w; i++)
				for(int j = r; j < r+h; j++)
					arr[j][i] = n;
		}
		
		for(int n = 1; n <= N; n++) {
			int cnt = 0;
			
			for(int i = 0; i < 101; i++)
				for(int j = 0; j < 101; j++)
					if(arr[i][j] == n) cnt++;
			
			System.out.println(cnt);
		}
		// sc.close();
	}
}
