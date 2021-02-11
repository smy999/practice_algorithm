package 재귀;

import java.io.*;

public class BJ_11729_하노이_탑_이동_순서 {
	
	static int N, K, COUNT;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(COUNT);
		System.out.println(sb);
	}
	
	static void hanoi(int n, int from, int tmp, int to) {
		
		COUNT++;
		
		if(n == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
		
		hanoi(n-1, from, to, tmp);
		sb.append(from + " " + to + "\n");
		hanoi(n-1, tmp, from, to);
	}
}
