package 큐_덱;

import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11866_요세푸스_문제0 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++)
			queue.offer(i);
		
		int cnt = 1;
		
		while(queue.size() > 1) {
			if(cnt == K) {
				sb.append(queue.poll() + ", ");
				cnt = 1;
			}
			else {
				queue.offer(queue.poll());
				cnt++;
			}
		}
		
		sb.append(queue.poll() + ">");
		
		System.out.print(sb);
		
	}
}
