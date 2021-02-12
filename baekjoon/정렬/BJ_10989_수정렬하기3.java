package 정렬;

import java.io.*;

/* 카운트 정렬 */

public class BJ_10989_수정렬하기3 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N];
		int[] result = new int[N];
		
		// 입력하면서 최대값 찾
		int max = 0;
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if(max < input[i]) max = input[i];
		}
		
		// 최대값만큼 카운트 배열 생성
		int[] count = new int[max+1];
		
		// 나온 숫자 카운트
		for(int i = 0; i < N; i++)
			count[input[i]]++;
		
		// 누적합
		for(int i = 1; i <= max; i++)
			count[i] += count[i-1];
		
		// i번째 원소를 카운트한 count 배열의 값을 1 감소한 후 result에 저장
		for(int i = N-1; i >= 0; i--) {
			result[--count[input[i]]] = input[i];
		}
			
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(result[i] + "\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
	
}
