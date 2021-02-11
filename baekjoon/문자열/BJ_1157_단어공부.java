package 문자열;

import java.io.*;
import java.util.*;

public class BJ_1157_단어공부 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 대문자 범위: 65~90, 소문자 범위: 97~122
		int[] alphabet = new int[26];
		
		char[] input = br.readLine().toCharArray();
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] <= 'Z')
				alphabet[input[i]-65]++;
			else
				alphabet[input[i]-97]++;
		}
		
		// System.out.println(Arrays.toString(alphabet));
		
		int max = 0, idx = 0;
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] > max) {
				max = alphabet[i];
				idx = i;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 26; i++)
			if(alphabet[i] == max) cnt++;

		// 출력은 대문자
		if(cnt == 1) System.out.println((char)(idx+65));
		else System.out.println("?");
	}
}
