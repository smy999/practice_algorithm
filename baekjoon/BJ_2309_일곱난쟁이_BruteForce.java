package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이_BruteForce {

	static int[] sevenDwarfs = new int[7];	// 정답 배열 = 일곱 난쟁이
	static int[] nineDwarfs = new int[9];	// 입력 배열 = 아홉 난쟁이 후보
	static boolean isSolved = false;		// 일곱 난쟁이 찾았는지 여부
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		for(int i = 0; i < 9; i++) {
			nineDwarfs[i] = Integer.parseInt(br.readLine());
		}
		
		// 조합으로 정답 구하기
		comb(0, 0, 0);
		
		// 정답 배열 정렬
		Arrays.sort(sevenDwarfs);
		
		// 출력 문자열 만들기
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 7; i++) {
			sb.append(sevenDwarfs[i]).append("\n");
		}
		
		// 출력
		System.out.print(sb);
	}
	
	public static void comb(int srcIdx, int tgtIdx, int sum) {
		// 정답이 하나라도 나왔으면 더이상 조합하지 않는다.
		if(isSolved) return;
		
		// 정답 배열이 다 찾을 때 = 하나의 조합이 완성되었을 때
		if(tgtIdx == 7) {
			// 일곱 난쟁이를 찾았을 때 isSolved로 찾았다는 표시를 한다.
			if(sum == 100) isSolved = true;
			return;
		}
		
		// 입력 배열의 범위를 넘어갔을 때
		if(srcIdx == 9) return;
		
		// 하나씩 적용해본다.
		sevenDwarfs[tgtIdx] = nineDwarfs[srcIdx];
		
		// 현재 인덱스에 치한 난쟁이 후보를 일곱 난쟁이에 넣었을 때
		comb(srcIdx+1, tgtIdx+1, sum+nineDwarfs[srcIdx]);
		// 넣지 않았을 때
		comb(srcIdx+1, tgtIdx, sum);
	}
}
