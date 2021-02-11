package 브루트포스;

import java.io.*;
import java.util.*;

public class BJ_7568_덩치 {
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] person = new int[N][2];
		int[] dungchi = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int[] tmp = {person[i][0], person[i][1]};
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(tmp[0] < person[j][0] && tmp[1] < person[j][1])
					dungchi[i]++;
			}
			System.out.print(dungchi[i]+1 + " ");
		}
	}
}
