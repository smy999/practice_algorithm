package 스택;

import java.io.*;
import java.util.*;

public class BJ_10828_스택 {

	static int N;
	static int[] arr;
	static int lastIdx;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		
		Stack stack = new Stack();

		StringTokenizer st;

		for(int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			switch(st.nextToken()) {
			case "push": stack.push(Integer.parseInt(st.nextToken())); break;
			case "pop": stack.pop(); break;
			case "size": stack.size(); break;
			case "empty": stack.empty(); break;
			case "top": stack.top(); break;
			}
		}

	}

	static class Stack{
		

		public void push(int num) {
			arr[lastIdx++] = num;
		}

		public void pop() {
			if(lastIdx == 0) {
				System.out.println("-1");
			} else {
				System.out.println(arr[lastIdx-1]);
				arr[lastIdx--] = 0;
			}
		}

		public void size() {
			System.out.println(lastIdx);
		}

		public void empty() {
			if(lastIdx == 0) System.out.println("1");
			else System.out.println("0");
		}

		public void top() {
			if(lastIdx == 0) System.out.println("-1");
			else System.out.println(arr[lastIdx-1]);
		}
	}
}
