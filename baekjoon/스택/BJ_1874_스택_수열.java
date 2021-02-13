package 스택;

import java.io.*;
import java.util.Stack;

public class BJ_1874_스택_수열 {

	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] input = new int[N];

		for(int i = 0; i < N; i++)
			input[i] = Integer.parseInt(br.readLine());

		int idx = 0;
		for(int i = 1; i <= N; i++) {

			stack.push(i);
			sb.append("+\n");

			while(!stack.isEmpty() && stack.peek() == input[idx]) {
				stack.pop();
				sb.append("-\n");
				idx++;
			}
		}

		if(stack.isEmpty()) System.out.print(sb);
		else System.out.print("NO");

		br.close();
	}
}
