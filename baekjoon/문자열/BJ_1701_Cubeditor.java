package Sep_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1701_Cubeditor {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int max = 0;
		
		for(int i = 0; i < len; i++) 
			max = Math.max(max, getMax(str.substring(i, len)));
		
		System.out.print(max);
	}
	
	// KMP 알고리즘 사용 
	// 해당 문자열 내에 존재하는 부분 문자열 중 접두사와 접미사가 같은 문자열의 최대 길이 구하기.
	// 원래는 pi배열을 리턴하여 문자열 탐색에 KMP 알고리즘으로 사용된다.
	public static int getMax(String s) {
		int j = 0;	// j : 좌측(접두사) 비교 문자열 인덱스 
		int n = s.length();
		int max = 0;
		
		int[] pi = new int[n];
		
		for(int i = 1; i < n; i++) {	// i : 우측(접미사) 비교 문자열 인덱스 
			while(j > 0 && s.charAt(i) != s.charAt(j)) 
				j = pi[j-1];
			
			if(s.charAt(i) == s.charAt(j)) 
				max = Math.max(max,  pi[i] = ++j);
		}
		
		return max;
	}
}
