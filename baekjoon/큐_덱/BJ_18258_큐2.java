package 큐_덱;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_18258_큐2 {
	
	static int N;
	static int[] queue;
	static int tailIdx = 0;
	static int frontIdx = 0;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue q = new Queue();
		
		N = Integer.parseInt(br.readLine());
		
		queue = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push": q.push(Integer.parseInt(st.nextToken())); break;
			case "pop": q.pop(); break;
			case "size": q.size(); break;
			case "empty": q.empty(); break;
			case "front": q.front(); break;
			case "back": q.back(); break;
			}
		}
		
		System.out.print(sb);	// 시간초과: StringBuilder로 변경 후 해결
	}
	
	static class Queue{
		
		public Queue() {}
		
		public void push(int num) {
			queue[tailIdx++] = num;
		}
		
		public void pop() {
			if(tailIdx == frontIdx) {
				sb.append("-1\n");
			}
			else {
				sb.append(queue[frontIdx++] + "\n");
			}
		}
		
		public void size() {
			sb.append(tailIdx-frontIdx + "\n");
		}
		
		public void empty() {
			if(tailIdx == frontIdx) sb.append("1\n");
			else sb.append("0\n");
		}
		
		public void front() {
			if(queue[frontIdx] == 0) sb.append("-1\n");
			else sb.append(queue[frontIdx] + "\n");
		}
		
		public void back() {
			if(tailIdx == frontIdx) sb.append("-1\n");	// 런타임 에: 큐가 비었을 때 조건 잘못 설정
			else sb.append(queue[tailIdx-1] + "\n");
		}
	}
}
