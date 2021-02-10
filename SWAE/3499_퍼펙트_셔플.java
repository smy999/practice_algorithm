package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트_셔플 {
	static int T, N, idx;
	static String[] deck;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			sb.setLength(0);			// 출력 문자열 초기화
			sb.append("#" + t + " ");	// 테스트케이스 출력 형식 맞추기
			
			/* line 24~31: 입력*/
			N = Integer.parseInt(br.readLine());
			
			deck = new String[N];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				deck[n] = st.nextToken();
			}
			
			/* 홀짝에 따라 기준점 정하기*/
			if(N%2 == 0) idx = N/2;	// 짝수일 때 기준점 N/2부터 시작
			else idx = N/2+1;		// 홀수일 때 기준점 N/2+1부터 시작
			
			/* sb에 deck 쌓기 */
			for(int i = 0; i < idx; i++) {		// 기준점까지만 반복한다.
				sb.append(deck[i]).append(" ");	// 순서대로 sb에 추가
				if(i+idx == N) break;			// 현재위치 + 기준점이 N이라면 반복문 탈출
				else sb.append(deck[i+idx]).append(" ");// 현재위치에서 기준점만큼 떨어진 원소 추가
			}
			
			/* 출력 */
			sb.setLength(sb.length()-1);// 마지막 공백 제거
			System.out.println(sb);		// 출력
		}
	}
}
