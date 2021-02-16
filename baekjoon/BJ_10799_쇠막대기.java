package study20210220;

import java.io.*;
import java.util.Stack;

public class BJ_10799_쇠막대기 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		Stack<Character> stack = new Stack<>();

		int sticks = 0;
		int total = 0;

		for(int i = 0, size = str.length(); i < size; i++) {
			
			char bracket = str.charAt(i);
			
			if(bracket == '(') { 
				sticks++;	// 열린 괄호가 들어오면 무조건 쇠막대기의 수를 추가
			}
			else {
				// 1. 열린 괄호가 닫힌 괄호를 만나면 레이저이다. 레이저일 때는 쇠막대기를 추가하지 않으므로 쇠막대기 수 감소,
				// 2. 닫힌 괄호 앞에 닫힌 괄호가 오면 한 쇠막대기의 끝이므로 쇠막대기의 수를 감소한다.
				sticks--;	
				
				if(stack.peek() == '(') // 1. 레이저: 잘린 쇠막대기들 총 개수에 추가
					total += sticks;	
				else 					// 2. 쇠막대기의 끝: 레이저에 의해 잘린 쇠막대기 1개 추가
					total++;	
			}	
			stack.push(bracket);
		}
		
		total += sticks;			// 마지막 괄호부분 추가

		System.out.print(total);	// 결과 출력
		
		br.close();					// 스트림 닫기
	}

}
