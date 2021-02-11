package 브루트포스;

import java.io.*;
import java.util.*;

public class BJ_2798_블랙잭 {
	
	static int N, M, max;
	static int[] src;
	static int[] tgt;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		tgt = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			src[i] = Integer.parseInt(st.nextToken());
		
		comb(0, 0);
		
		System.out.print(max);
	}
	
	static void comb(int sIdx, int tIdx) {
		if(tIdx == 3) {
			int sum = 0;
			for(int t: tgt) sum += t;
			if(sum <= M && sum > max) max = sum;
			return;
		}
		
		if(sIdx == N) return;
		
		tgt[tIdx] = src[sIdx];
		
		comb(sIdx+1, tIdx+1);
		comb(sIdx+1, tIdx);
	}
	
}
