package Sep_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1213_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int[] palindrome = new int[26];
		
		for(char c : input) palindrome[c-'A']++;

		int oddCnt = 0;
		int oddInt = 0;
		
		int len = input.length;
		
		for(int i = 0; i < 26; i++) {
			if(palindrome[i]%2 == 1) {
				oddCnt++;
				oddInt = i;
			}
		}
		
		if ((len % 2 == 0 && oddCnt > 0) || (len % 2 == 1 && oddCnt != 1)) {
            System.out.printf("I'm Sorry Hansoo");
            return;
	    }
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 26; i++) {
            for (int j = 0; j < palindrome[i] / 2; j++) {
                System.out.print((char)(i + 'A'));
            }
        }
		
		if(len%2 == 1) sb.append((char)(oddInt + 'A'));
		
		for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < palindrome[i] / 2; j++) {
            	sb.append((char)(i + 'A'));
            }
        }
		
		System.out.print(sb);
	}
}



/*


AABBCCCDD
답 : ABCDCDCBA
출력 : ABCCDDCBA

*/
