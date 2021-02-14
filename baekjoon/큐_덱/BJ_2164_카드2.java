package 큐_덱;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_2164_카드2 {
	
	public static void main(String[]args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(true) {
			queue.poll();
			
			if(queue.size() == 1) break;
			
			queue.add(queue.poll());
		}
		
		System.out.print(queue.poll());
	}
}
