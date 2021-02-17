package workshop;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_15686_치킨배달 {

	static int N, M, min = Integer.MAX_VALUE;
	static StringTokenizer st;
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static int[][] tgt;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tgt = new int[M][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				
				if(input == 1) home.add(new int[] {i, j});
				else if(input == 2) chicken.add(new int[] {i, j});
			}
		}
		
		comb(0, 0);
		
		System.out.print(min);
		
	}
	
	private static void comb(int ckIdx, int tgtIdx) {
		if(tgtIdx == M) {
			int distance = 0;
			
			for(int i = 0; i < home.size(); i++)
				distance += getDistance(home.get(i)[0], home.get(i)[1]);
			
			if(min > distance) min = distance;
			
			return;
		}

		if(ckIdx == chicken.size()) return;
		
		tgt[tgtIdx] = chicken.get(ckIdx);
		
		comb(ckIdx+1, tgtIdx+1);
		comb(ckIdx+1, tgtIdx);
	}
	
	private static int getDistance(int r, int c) {
		
		int dist = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++) {
			int tmp = (int)Math.abs(r - tgt[i][0]) + (int)Math.abs(c - tgt[i][1]);
			if(dist > tmp) dist = tmp;
			if(dist == 1) return dist;
		}
		
		return dist;
	}
}
