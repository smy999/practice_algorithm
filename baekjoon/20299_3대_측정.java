import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20299_3대_측정 {
	static int N, S, M, sum, cnt;		// 신청 동아리수, 팀 가입 조건, 개인 능력치 조건, 팀원의 능력치 합, 가입가능한 동아리의 수
	static int[] level = new int[3];	// 팀원들의 능력치, 각 팀의 인원은 3명으로 정해져 있다.
	static boolean join;				// 가입 가능 여부 판단
	static StringTokenizer st;			// 공백을 분리하여 입력받기 위한 StringTokenizer
	static StringBuilder sb = new StringBuilder();	// 공백을 포함하여 출력하기 위한 StringBuilder

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// Buffer로 입력

		st = new StringTokenizer(br.readLine()); // 신청 동아리수, 팀 가입 조건, 개인 능력치 조건을 읽어 공백 단위로 분리

		N = Integer.parseInt(st.nextToken());	// 신청 동아리 수 입력
		S = Integer.parseInt(st.nextToken());	// 팀 능력치 입력
		M = Integer.parseInt(st.nextToken());	// 개인 능력치 입력

		sb.setLength(0); 						// 결과 초기화

		for(int i = 0; i < N; i++) {			// 신청 동아리 개수만큼 반복
			sum = 0;							// 팀원 3명의 능력치 합
			join = true;						// 가입 가능 여부 true로 초기 설정
			st = new StringTokenizer(br.readLine()); // 팀원 3명의 능력치를 입력받아 공백을 분리하여 저장


			for(int j = 0; j < 3; j++) {		// 팀원 3명의 능력치 입력
				level[j] = Integer.parseInt(st.nextToken());	// j+1 순서의 팀원의 능력치 입력
				if(level[j] < M) {				// 개인 능력치 미달이라면
					join = false;				// 가입 가능 여부를 false로 설정하고
					break;						// 반복문을 나간다.
				}
				sum += level[j];
			}

			if(join == true && sum >= S) {			// 만약 가입 가능 여부가 true이고, 팀원의 문제해결 능력의 합이 S이상이면
				cnt++;								// 가입 동아리 수를 증가
				for(int n = 0; n < 3; n++)			// 반복문을 돌며
					sb.append(level[n]).append(" ");// 동아리 팀원 3명 모두 결과 공백과 함께 추가
			}
		}
		System.out.println(cnt);					// 가입이 가능한 동아리 수 출력
		if(sb.length() > 0) sb.setLength(sb.length()-1);				// 마지막 공백 제거
		System.out.println(sb);						// 가입된 학생들의 능력치 출력
	}
}
