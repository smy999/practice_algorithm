package 큐_덱;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_2164_카드2 {

	public static void main(String[]args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();

		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());	// add보다 offer가 미세하게 더 빨랐다.
		}

		// 메모리 초과
		//		while(true) {
		//			queue.poll();
		//			if(queue.size() == 1) break;
		//			queue.add(queue.poll());
		//		}


		System.out.print(queue.poll());
	}
}
