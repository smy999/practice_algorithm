package 정렬;

import java.io.*;
import java.util.Arrays;

public class BJ_1427_소트인사이드 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] input = br.readLine().toCharArray();
		
		Arrays.sort(input);
		
		for(int i = input.length-1; i >= 0; i--)
			bw.write(input[i]);
		
		br.close();
		bw.close();
	}
}
