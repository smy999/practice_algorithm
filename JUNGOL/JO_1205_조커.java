package IM_20210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1205_조커 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 1. 필요 변수 입력
		st = new StringTokenizer(br.readLine());	// N 뒤에 공백이 포함되어 그냥 br.readLine()으로 받으면 오류난다.
		int N = Integer.parseInt(st.nextToken());	// 카드의 개수
		int[] card = new int[N];					// 카드 배열
		int zero = 0;					// 조커 개수
		
		// 2. 배열 입력
		st = new StringTokenizer(br.readLine());	// 카드 한 줄로 입력
		for(int i = 0; i < N; i++) {	// 카드 입력
			card[i] = Integer.parseInt(st.nextToken());
			if(card[i] == 0) zero++;	// 조커 개수 세기
		}
		
		// 3. 모든 카드가 조커라면 더이상 계산항 필요가 없으므로 출력하고 종료
		if(zero == N) {	
			System.out.println(N);
			return;
		}

		// 4. 카드 정렬
		Arrays.sort(card);

		int straight = 0;	// 스트레이드일 때 최대 카드 수
		int cntC, cntZ;		// 카드 수, 남은 조커 수

		// 5. 스트레이드 카드 수 구하기
		for(int i = zero; i < N-1; i++) {

			cntC = 1;		// 카드 수 1부터 시작
			cntZ = zero;	// 남은 조커의 수 초기 조커 수부터 시작

			for(int j = i; j < N-1; j++) {	// j+1 비교를 위해 N-1까지만 반복
				int tmp = card[j];
				if(tmp == card[j+1]) {	// 1. 다음 카드가 같은 숫자를 가지면 다음으로 넘어간다.
					continue;
				}
				if(tmp+1 == card[j+1]) {// 2. 다음 카드가 현재 카드보다 1만큼 크다면 스트레이트 카드 수 증가한다.
					cntC++;	
				}
				else {					// 3. 다음 카트가 현재 카드보다 1만큼 크지 않아 스트레이트가 아닐 때
					if (cntZ+1 >= card[j+1]-tmp) {	// 3-1. 조커가 다음 (카드 수 - 현재 카드 숫자 -1) 이상 있을 때
						cntZ-= card[j+1]-tmp-1;		// 쓸 수 있는 만큼의 조커를 쓴다.
						cntC+=card[j+1]-tmp;		// 쓴 조커의 수 + 다음 카드 만큼 더해준다.
					} 
					else {				// 3-2. 다음 숫자로 이어지기에 조커 수가 부족할 때
						break;			// 반복문을 나가서 cntC에 남은 조커의 개수를 더해준다. (line 56)
					}
				}
			}
			cntC += cntZ;	// 남은 조커의 수를 더해준다.
			straight = Math.max(straight, cntC);	// 스트레이트 카드 개수의 최대값을 갱신한다.
		}

		System.out.println(straight);
	}
}
