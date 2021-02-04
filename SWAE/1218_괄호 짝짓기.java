package workshop;


// 1218_괄호 짝짓기.java

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWEA_1218 {
	static int N, validity;
	static char[] bracket;
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t = 1; t <= 10; t++) {

			N = Integer.parseInt(br.readLine());
			bracket = new char[N];
			bracket = br.readLine().toCharArray();

			for(int n = 0; n < N; n++) {
				validity = 1;
				if (bracket[n] == '(' || bracket[n] == '[' || bracket[n] == '{' || bracket[n] == '<') {
					stack.push(bracket[n]);
				} else {
					if(bracket[n] == ')' && stack.peek() == '(') {
						stack.pop();
					} else if(bracket[n] == ']' && stack.peek() == '[') {
						stack.pop();
					} else if(bracket[n] == '}' && stack.peek() == '{') {
						stack.pop();
					} else if(bracket[n] == '>' && stack.peek() == '<') {
						stack.pop();
					} else { 
						validity = 0; break;
					}
				}
			}

			System.out.println("#" + t + " " + validity);
			stack.clear();
		}

	}
}
