package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1158_요세푸스 {
	
	static int N, K, cnt=1, index;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++)
			queue.add(i);
		
		sb.append("<");
		
		while(queue.size()!=1) {
			if(cnt == K) {
				sb.append(queue.poll()).append(", ");
				cnt = 1;
			}else {
				cnt++;
				queue.add(queue.poll());
			}
			
		}
		sb.append(queue.poll()).append(">");
		System.out.println(sb);
	}
	
}
