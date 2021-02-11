package 문자열;

import java.io.*;

public class BJ_1316_그룹단어체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] alphabet;
		int size = N;
		
		for(int i = 0; i < N; i++) {

			alphabet = new int[26];
			
			char[] input = br.readLine().toCharArray();
			
			alphabet[input[0]-97]++;
			
			for(int j = 1; j < input.length; j++) {
				
				alphabet[input[j]-97]++;
				
				if(alphabet[input[j]-97] > 1) {
					alphabet[input[j]-97]--;
					if(input[j] != input[j-1]) {
						size--;
						break;
					}
				}
			}
		}
		
		System.out.print(size);
	}
}
