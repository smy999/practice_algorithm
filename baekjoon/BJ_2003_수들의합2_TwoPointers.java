
// https://m.blog.naver.com/kks227/220795165570

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2003_수들의합2_TwoPointers {
	
	static int N, M, start, end, sum, cnt;
	static int[] A;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		
		st = new StringTokenizer(br. readLine());
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		while(true) {
			if(sum >= M) sum -= A[start++];
			else if(end == N) break;
			else sum += A[end++];
			
			if(sum == M) cnt++;
		}
		
		System.out.println(cnt);
	}
}
