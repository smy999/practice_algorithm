package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1339_단어수학 {

	static int N, ans;
	static String[] words;
	static int[] alphabet = new int[26];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N  = Integer.parseInt(br.readLine());
		words = new String[N];
		
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			String temp = words[i];
			for(int j = 0; j < temp.length(); j++) {
				// 자리수만큼 10 곱하기
				alphabet[temp.charAt(j) - 65] += (int)Math.pow(10, (temp.length()-j-1));
			}
		}
		
		Arrays.sort(alphabet);
		
		for(int i = 25, j = 9; i >= 0; i--, j--) {	// 9에서부터 값 넣어주기
			if(alphabet[i] == 0) break;	// 0이 나오면 더이상 나올 숫자가 없음을 의미
			ans += alphabet[i]*j;
		}
		
		System.out.print(ans);
	}
}
