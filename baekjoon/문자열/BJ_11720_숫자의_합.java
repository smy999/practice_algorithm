package 문자열;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

import java.io.*;
// import java.util.*;

public class BJ_11720_숫자의_합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
//		char[] num = new char[N];
		char[] num;
		num = br.readLine().toCharArray();
		
		for(int i = 0; i < N; i++) {
			sum += num[i] - '0';
		}
		
		System.out.println(sum);
	}

}
