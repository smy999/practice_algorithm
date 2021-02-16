package study20210220;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class BJ_2841_외계인의_기타_연주 {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		// 스택 배열로 선언, 할당하는 법 구글링
		Stack<Integer>[] stack = new Stack[7];

		for(int i = 0; i < 7; i++) {
			stack[i] = new Stack<Integer>();
			stack[i].push(0);
		}
		
		int total = 0;

		for(int i = 0; i < N; i++) {
			int move = 0;
			
			st = new StringTokenizer(br.readLine());

			int line = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());

			// 줄 번호가 같을 때
			while(stack[line].size() != 1) {
				// 이전 프렛이 현재 프렛보다 클 때
				if(stack[line].peek() > fret) {
					stack[line].pop();	// 이전 프렛 제거
					move++;				// 움직임 증가
				}
				// 이전 프렛이 현재 프렛보다 작거나 같을 때
				else {
					// 이전 프렛과 현재 프렛이 갈을 때
					if(stack[line].peek() == fret) {
						// move--;		// 이미 눌러져 있기 때문에 움직임 없음
					}
					// 이전 프렛이 현재 프렛보다 작을 때
					else {
						stack[line].push(fret);	// 현재 음 추가
						move++;					// 움직임 증가
					}
					// 현재 프렛 움직임 완료 후 반복문 탈출
					break;
				}
			}

			// 스택이 빈 스택일 때(= top이 초기값 0이고, 크기가 1일 때)
			if(stack[line].size() == 1) {
				stack[line].push(fret);		// 프렛 추가
				move++;						// 움직임 증가
			}
			
			total += move;	// 줄에 따라 움직임을 따로 합산
		}

		System.out.print(total);	// 결과 출력
		br.close();
	}

}




/*

7 15
1 5
2 3
2 5
2 7
2 4
1 5
1 3

 */

