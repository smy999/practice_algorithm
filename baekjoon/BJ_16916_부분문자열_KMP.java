package Jan_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_16916_부분문자열_KMP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String P = br.readLine();
		
		int pLen = P.length();
		int[] pattern = new int[P.length()];
		
		// pattern에 접미사와 접두사의 일치하는 길이를 구해 저장한다.
		int j = 0;
		for(int i = 1; i < pLen; i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) j = pattern[j-1];
			if(P.charAt(i) == P.charAt(j)) pattern[i] = ++j;
		}
		
		// KMP
		j = 0;
		for(int i = 0; i < S.length(); i++) {
			while(j > 0 && S.charAt(i) != P.charAt(j)) j = pattern[j-1];
			if(S.charAt(i) == P.charAt(j)) {
				if(j == pLen-1) {	// j는 P의 index이므로 j가 P의 마지막 index이라면 S에서 P를 찾았음을 의미
					System.out.print(1);
					return;
				} else {			// 비교하는 문자가 같으면 S와 P의 index 증가시켜 다음 문자 비교
					++j;
				}
			}
		}
		
		System.out.print(0);
	}
}
