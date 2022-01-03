package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2504_괄호의값 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] bracket = br.readLine().toCharArray();
		int len = bracket.length;
		
		Stack<Character> stack = new Stack<>();
		int ans = 0, multi = 1;
		boolean flag = false;
		
		for(int i = 0; i < len; i++) {
			if(bracket[i] == '(') {
				multi *= 2;
				stack.push('(');
			} else if(bracket[i] == '[') {
				multi *= 3;
				stack.push('[');
			} else if(bracket[i] == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					flag = true;
					break;
				}
				// line 35: stack.peek()가 아닌 이유? 원래 문자열에서 ..()인 형태와 ([])인 형태는 다르다.
				// ..()의 경우 ..와 덧셈을, ([])은 곱셈이기 때문!
				// 그러나 곱셈인 경우 열린 괄호를 stack에 넣을 때 처리했기 때문에 multi에서 2를 나눈다.
				// 아래 닫힌 중괄호도 같은 방식.
				if(bracket[i-1] == '(') {
					ans += multi;
				}
				stack.pop();
				multi /= 2;
			} else if(bracket[i] == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					flag = true;
					break;
				}
				if(bracket[i-1] == '[') {
					ans += multi;
				}
				stack.pop();
				multi /= 3;
			}
		}

		
		System.out.print(stack.empty() && !flag ? ans : 0);
	}
}
