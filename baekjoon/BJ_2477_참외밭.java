package IM_20210223;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2477_참외밭 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		int[] points = new int[6];

		int smallR = 0, smallC = 0;
		int bigR = 0, bigC = 0;
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			points[i] = Integer.parseInt(st.nextToken());
			
			if(i%2 == 0) bigC = Math.max(bigC, points[i]);
			else bigR = Math.max(bigR, points[i]);
		}
		
		for(int i = 0; i < 6; i++) {
			if(i%2 == 0) {
				if(bigR == points[(i+5)%6] + points[(i+1)%6]) smallC = points[i];
			} else {
				if(bigC == points[(i+5)%6] + points[(i+1)%6]) smallR = points[i];
			}
		}
		
		System.out.print((bigR*bigC - smallR*smallC)*K);
	}
}
