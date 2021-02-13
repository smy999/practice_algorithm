package 스택;

import java.io.*;
import java.util.Stack;

public class BJ_9012_괄호 {

	static int N;
	static boolean flag;
	static char[] arr;
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			arr = br.readLine().toCharArray();

			flag = true;
			
			for(int j = 0; j < arr.length; j++) {
				
				if(arr[j] == '(') {
					stack.push('(');
				}
				else if(stack.isEmpty()) {
					flag = false; break;
				}
				else {
					stack.pop();
				}
			}

			if(stack.isEmpty() && flag) System.out.println("YES");
			else System.out.println("NO");

			stack.clear();
		}
	}
}
