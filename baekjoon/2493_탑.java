package hwalgo04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


// stack에 내림차순으로 정렬하는 것. 오름 차순을 제거한다.
// Scanner는 시간초과
// stack은 2개를 쓰는 것보다 하나를 배열로 쓰는 것이 좋다 > 데이터에 대한 공간을 잡아먹는 건 같다.
// 하지만 스택은 공간이 하나 더 필요하기 때문에 메모리적으로도 스택 2개가 더 손해이다.

public class BJ_2493 {
	static int N, idx;	
	static int top;
	static Stack<int[]> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder("");

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 1; i <= N; i++) {
			top = Integer.parseInt(st.nextToken());

			while(!stack.isEmpty()) {	
				if(stack.peek()[0] < top) {	// stack의 제일 위의 원소보다 현재 입력된 수가 클 때
					stack.pop();
				}else {
					idx = stack.peek()[1];
					stack.push(new int[] {top, i});
					break;
				}
			}
			if(stack.isEmpty()) {			// stack이 비어있으면 push
				stack.push(new int[] {top, i});
				idx = 0;
			}

			sb.append(idx).append(" ");
		}
		System.out.print(sb.substring(0, sb.length() - 1));	// 공백 제거르 위해 StirngBuilder 사용
		stack.clear();	// stack 비우자
	}
}



/*
 * 교수님 로직 = 거의 비슷하다.
 */
/*
while(!stack.isEmpty()) {	
	if(stack.peek()[0] > top) {
		idx = stack.peek()[1];
		break;
	}
	stack.pop();
}
if(stack.isEmpty()) {			// stack이 비어있으면 push
	idx = 0;
}
stack.push(new int[] {top, i});
sb.append(idx).append(" ");
*/




