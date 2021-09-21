package Sep_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// KMP

public class BJ_16916_부분문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();	// 전체 문자열
		String P = br.readLine();	// 패턴 문자열
		
		System.out.print(KMP(S, P));
	}
	
	public static int KMP(String S, String P) {
		// pi 배열 만들기
		int j = 0;
		int len = P.length();

		int pi[] = new int[P.length()];
		
		for(int i = 1; i < len; i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) j = pi[j-1];
			if(P.charAt(i) == P.charAt(j)) pi[i] = ++j;
		}
		
		// P와 맞는 부분 문자열 찾기
		j = 0;
		for(int i = 0; i < S.length(); i++) {
			while(j > 0 && S.charAt(i) != P.charAt(j)) j = pi[j-1];
			if(S.charAt(i) == P.charAt(j)) {
				if(j == len-1) return 1;	// 맞는 문자열 있을 때
				else j++;
			}
		}
		
		// 맞는 문자열 없을 때
		return 0;
	}
}
