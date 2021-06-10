package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 규칙찾기: https://blog.naver.com/occidere/220854811310

public class BJ_2302_극장좌석_DP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 좌석의 크기와 VIP 회원의 수
		int N = Integer.parseInt(br.readLine());
		
		// 최대 회원의 수만큼 피보나치 수열 생성
		int DP[] = new int[N+1];
		DP[0] = 1;
		DP[1] = 1;
		DP[2] = 2;
		for(int i = 3; i <= N; i++) {
			DP[i] = DP[i-1] + DP[i-2];
		}

		// 고정석을 기준으로 각 경우의 수를 곱하여 구한다.		
		int M = Integer.parseInt(br.readLine());	// 고정석 개수
		int total = 1;								// 최종 경우의 수
		int vipPre = 0;								// 고정석 초기값 0(아직 입력받은 고정석이 없다면 처음부터 경우의 수를 구해야하므로)
		for(int i = 0; i < M; i++) {
			int vipNo = Integer.parseInt(br.readLine());	// 고정석 입력
			total *= DP[vipNo - vipPre - 1];		// 고정석이 존재하지 않는 범위의 경우의 수 구하기
			vipPre = vipNo;							// 이전 고정석을 현재 고정석으로 변경
		}
		
		// 마지막 고정석 뒤의 좌석 배치 경우의 수를 최종 경우의 수에 곱해줘야 한다.
		total *= DP[N-vipPre];
		
		// 결과 출력
		System.out.print(total);
	}
}
