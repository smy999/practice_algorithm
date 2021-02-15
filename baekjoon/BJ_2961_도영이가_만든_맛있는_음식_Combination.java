package workshop;

// 풀이1: 조합 사용

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2961_도영이가_만든_맛있는_음식_Combination {

	static int min = Integer.MAX_VALUE;	// 신맛과 쓴맛의 차이
	static StringTokenizer st;
	
	static int[][] input;	// 입력 재료
	static int[][] flavor;	// 사용 재료
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		input = new int[N][2];
		
		// 재료 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 배열의 크기 1부터 N까지 모두 만든다.
		for(int i = 1; i <= N; i++) {
			flavor = new int[i][2];
			combination(i, 0, 0);
		}
		
		System.out.print(min);	// 결과 출력
		
		br.close();				// 스트림 닫기
	}
	
	static void combination(int cnt, int inputIdx, int flavorIdx) {
		if(flavorIdx == cnt) {
			int sour = 1;	// 초기값 1 > 곱셈
			int bitter = 0;	// 초기값 0 > 덧셈
			
			for(int i = 0; i < cnt; i++) {
				sour *= flavor[i][0];	// 신맛 = 재료 신맛의 곱
				bitter += flavor[i][1];	// 쓴맛 = 재료 쓴맛의 합
			}
			
			int differ = (int)Math.abs(sour-bitter);// 현재 flavor 배열의 신맛과 쓴맛의 차이 구하기
			
			if(differ < min) min = differ; 			// 가장 작은 차이 구하기
			
			return;
		}
		
		if(inputIdx == input.length) return;		// input 끝까지 검색하면 반환
		
		flavor[flavorIdx] = input[inputIdx];		// 재료 사용
		combination(cnt, inputIdx+1, flavorIdx+1);	// 선택
		combination(cnt, inputIdx+1, flavorIdx);	// 미선택
	}
}
