package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10773_제로 {
	
	static int N;
	static int[] arr;
	static int lastIdx;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		Stack stack = new Stack();
		
		int input;
		
		for(int i = 0; i < N; i++) {
			input = Integer.parseInt(br.readLine());
			if(input == 0)
				stack.pop();
			else
				stack.push(input);
		}
		
		stack.print();
	}
	
	static class Stack{
		public void push(int input) {
			arr[lastIdx++] = input;
		}
		
		public void pop() {
			arr[lastIdx--] = 0;
		}
		
		public void print() {
			int sum = 0;
			for(int i = 0; i < lastIdx; i++) {
				sum += arr[i];
			}
			System.out.println(sum);
		}
	}
}
