package workshop;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1074_Z_Divide {
	
	static int visit;	// 방문 번호
	static int r;		// x, 행
	static int c;		// j, 열
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());	// x, 행
		c = Integer.parseInt(st.nextToken());	// y, 열
		
		divide(0, 0, (int)Math.pow(2, N)/2);
		
		System.out.print(visit);
		
		br.close();
	}
	
	static void divide(int x, int y, int n) {
		if(n < 1) return;	// n이 1일 때도 실행되어야 한다.
		
		// 상좌
		if(r < x+n && c < y+n) {	
		}
		// 상우
		else if(r < x+n && c >= y+n) {
			visit += n*n;
			y += n;
		}
		// 하좌
		else if(r >= x+n && c < y+n) {
			visit += n*n*2;
			x += n;
		}
		// 하우
		else {
			visit += n*n*3;
			x += n;
			y += n;
		}
		
		divide(x, y, n/2);
	}
}
