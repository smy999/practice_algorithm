package study20210220;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.LinkedList;

public class BJ_12789_도키도키_간식드리미_Stack_Queue {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 승환이 앞에 서 있는 학생 수
		
		Stack<Integer> stack = new Stack<>();			// 대기, 한 명씩 설 수 있는 곳: 후입선출
		LinkedList<Integer> queue = new LinkedList<>();	// 입력, 현재 줄 서있는 곳: 선입선출
		
		// queue에 학생 번호표 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			queue.offer(Integer.parseInt(st.nextToken()));
		
		
		int order = 1;	// 1번째부터 받는다.
		
		// queue를 비운다.
		while(!queue.isEmpty()) {
			
			if(queue.peek() != order) {
				if(!stack.isEmpty() && stack.peek() == order) {
					stack.pop();
					order++;
					continue;
				}
				
				stack.push(queue.poll());
			}else {
				queue.poll();
				order++;
			}
		}
		
		// stack을 비운다.
		while(!stack.isEmpty()) {
			if(order != stack.peek()) break;
			else {
				order++;
				stack.pop();
			}
		}
		
		// 결과 출력
		if(stack.isEmpty()) System.out.println("Nice");
		else System.out.println("Sad");
	}
}
