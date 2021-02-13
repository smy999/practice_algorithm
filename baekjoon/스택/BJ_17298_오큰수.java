package 스택;

// 문제: https://www.acmicpc.net/problem/17298
// 풀이참고: https://makeupthebed.tistory.com/17

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17298_오큰수 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		int[] input = new int[N];
		int[] result = new int[N];
		
		Stack<Integer> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i< N; i++)
			input[i] = Integer.parseInt(st.nextToken());

		// 뒤에서부터 비교
		for(int i = N-1; i >= 0; i--) {
			if(stack.isEmpty()) {		// 스택이 비었다면 결과 배열에 마지막에 -1 할당
				stack.push(input[i]);	// 입력 배열의 마지막 값 스택에 추가
				result[i] = -1;
			}
			else {	// 스택이 비어있지 않다면
				while(!stack.isEmpty()) {	// 스택이 비어있지 않을 동안
					// 틀린이유1: 비교 <로해서 <=로 변경 후 정답
					if(stack.peek() <= input[i]) stack.pop();	// 현재 값이 스택의 값보다 같거나 크면 스택에서 삭제(내립차순 유지)
					else break;	// 현재 값이 이전 값보다 작으면 반복문 탈
				}
				if(stack.isEmpty()) result[i] = -1;	// 현재 값이 스택의 모든 값보다 크다면 결과 배열에 -1추가
				else result[i] = stack.peek();		// 현재 값이 이전 값보다 작으면 top을 결과 배열에 추가
				
				stack.push(input[i]);	// 현재 값 배열에 추가
			}
		}
		
		for(int i = 0; i < N; i++) {	// 결과 출
			bw.write(result[i] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
