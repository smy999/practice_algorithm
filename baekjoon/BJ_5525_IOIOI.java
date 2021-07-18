package July_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5525_IOIOI {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();

		int cnt = 0;
		int matchCnt = 0;
		
		for(int i = 1; i < M-1; i++) {
			if(S[i-1] == 'I' && S[i] == 'O' && S[i+1] == 'I') {
				matchCnt++;				// IOI 한 set가 맞으면 매치 카운트 증가
				if (matchCnt == N) {	// 캐치 카운트가 N과 같으면 PN을 찾은 것이다.
					matchCnt--;			// 그럼 맨 앞의 IOI를 지우고 뒤에 하나를 더 찾는다.
					cnt++;				// PN의 총개수를 증가한다.
				}
				i++;					// IOI가 매치되면 2칸을 옆으로 가야하기 때문에 1만큼 더해준다.
			} else {					// 매치카운트가 끊기면 처음부터 다시 찾는다.
				matchCnt = 0;
			}
		}
		
		System.out.print(cnt);
	}
}
