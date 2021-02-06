package hwalgo05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// 1223. [S/W 문체해결 기본] 9일차 - 사칙연산 유효성 검사

public class SWEA_1223 {

	static int T = 10, N,left, right;
	static char[] input;
	static String postfix;
	static Stack<Character> operator = new Stack<>();
	static Stack<Integer> calc = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input_1223.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			input = br.readLine().toCharArray();

			// System.out.println(Arrays.toString(input));

			postfix = "";
			calc.clear();

			// 후위식 만들기
			for(int i = 0; i < N; i++) {
				if(input[i] - '0' >= 0 && input[i] - '0' <= 9) {
					postfix+=input[i];
					continue;
				}
				if(operator.isEmpty()) {
					operator.push(input[i]);
				} else {
					while(!operator.isEmpty()) 
						if (operator.peek() <= input[i]) 
							postfix += operator.pop();
						else break;
					operator.push(input[i]);
				}
			}

			while(!operator.isEmpty())
				postfix += operator.pop();

			// System.out.println(postfix);

			left = 0;
			right = 0;
			for(int i = 0; i < N; i++) {
				char tmp = postfix.charAt(i);
				if(tmp - '0' >= 0 && tmp - '0' <= 9) {
					calc.push(tmp - '0');
				} else {
					right = calc.pop();
					left = calc.pop();

					switch(tmp) {
					case '*':
						calc.push(left * right);
						break;
					case '+':
						calc.push(left + right);
						break;
					}
				}
			}
			System.out.println("#" + t + " " + calc.pop());
		}
	}
}
