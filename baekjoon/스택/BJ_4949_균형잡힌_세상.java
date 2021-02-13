package 스택;

import java.io.*;
import java.util.Stack;


public class BJ_4949_균형잡힌_세상 {
	
	static char[] input;
	static boolean flag;
	static String str;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			str = br.readLine();
			
			if(str.equals(".")) break;
			
			input = str.toCharArray();
			
			flag = true;
			
			for(int i = 0; i < input.length; i++) {
				if(input[i] == '(' || input[i] == '[') {
					stack.push(input[i]);
				}else if(input[i] == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					}
					else {
						stack.pop();
					}
				}else if(input[i] == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			if(flag == true && stack.isEmpty())
				System.out.println("yes");
			else
				System.out.println("no");
			
			stack.clear();
		}
	}
}
