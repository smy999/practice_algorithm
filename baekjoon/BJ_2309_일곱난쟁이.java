package hwalgo14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_2309_일곱난쟁이 {	
	
	static boolean flag = false;
	static int[] dwarf = new int[9];
	static int[] tgt = new int[7];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 9; i++)
			dwarf[i] = Integer.parseInt(br.readLine());

		comb(0, 0);
		
		br.close();
	}
	
	private static void comb(int tgtIdx, int dIdx) {
		
		if(flag) return;
		
		if(tgtIdx == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) sum += tgt[i];
			if(sum == 100) {
				Arrays.sort(tgt);
				for(int t : tgt) System.out.println(t);
				flag = true;
			}
			return;
		}
		
		if(dIdx == 9) return;
		
		tgt[tgtIdx] = dwarf[dIdx];
		
		comb(tgtIdx+1, dIdx+1);
		comb(tgtIdx, dIdx+1);
	}
}
