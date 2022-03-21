package Mar_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3568_iSharp_시뮬레이션 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String basic = st.nextToken();
		
		StringBuilder sb = new StringBuilder();
		String front = "", back = "";
		while(st.hasMoreTokens()) {
			String additional = st.nextToken();
			for(int i = additional.length()-2; i >= 0; i--) {
				if(additional.charAt(i) == ']') {
					front += "[]";
					i--;
				} else if(additional.charAt(i) == '*') {
					front += "*";
				} else if(additional.charAt(i) == '&') {
					front += "&";
				} else {	// 주의 변수명의 길이가 1 이상일 수 있다.
					back = additional.substring(0, i+1);
					break;
				}
			}
			sb.append(basic).append(front).append(" ").append(back).append(";").append("\n");
			front = ""; back = "";
		}
		
		System.out.print(sb);
	}
}
