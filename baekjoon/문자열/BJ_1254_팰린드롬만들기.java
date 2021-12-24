package Dec_week3_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1254_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 입력
		String S = br.readLine();
		System.out.print(getLen(S));
	}
	
	// 팰린드롬 만들기
	public static int getLen(String S) {
		int sLen = S.length();
		// 1. S의 마지막부터 팰린드롬이 존재하는 경우
		// 1-1. S 자체가 팰린드롬
		// 1-2. S의 마지막을 포함하는 일무 부분 문자열이 팰린드롬
		for(int i = 0; i < sLen; i++) {
			if(isPalin(S.substring(i))) return sLen+i;
		}
		// 2. 팰린드롬이 존재하지 않는 경우
		return sLen*2-1;
	}

	// 팰린드롬 판단하기
	public static boolean isPalin(String sub) {
		int subLen = sub.length();
		// 양쪽 끝에서 가운데로 모이면서 팰린드롬인지 확인
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) != sub.charAt(subLen-i-1)) return false;
		}
		return true;
	}
}
