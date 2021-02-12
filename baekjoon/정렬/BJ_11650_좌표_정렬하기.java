package 정렬;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BJ_11650_좌표_정렬하기{
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] location = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			location[i][0] = Integer.parseInt(st.nextToken());
			location[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(location, (i1, i2) -> {
			if(i1[0] == i2[0]) return i1[1] - i2[1];
			else return i1[0] - i2[0]; 
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(location[i][0] + " " + location[i][1] + "\n");
		}
		
		System.out.println(sb);
	}
	
}
