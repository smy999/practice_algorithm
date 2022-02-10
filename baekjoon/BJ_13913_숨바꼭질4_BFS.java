package Feb_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13913_숨바꼭질4_BFS {
	
	public static void main(String[] arge) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N, 0});
		
		boolean[] visited = new boolean[100001];
		
		int[] parent = new int[100001];
		Arrays.fill(parent, -1);
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();

			if(visited[cur[0]]) continue;
			visited[cur[0]] = true;
			
			if(cur[0] == K) {
				StringBuilder sb = new StringBuilder();
				sb.append(cur[1]).append("\n");
				
				Stack<Integer> stack = new Stack<>();
				stack.push(K);
				
				int k = K;
				while(k != N) {
					stack.add(parent[k]);
					k = parent[k];
				}
				while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
				
				System.out.print(sb);
				
				return;
			}
			
			int next = cur[0] + 1;
			if(next <= 100000 && parent[next] == -1) {
				queue.add(new int[] {next, cur[1]+1});
				parent[next] = cur[0];
			}
			next = cur[0] * 2;
			if(next <= 100000 && parent[next] == -1) {
				queue.add(new int[] {next, cur[1]+1});
				parent[next] = cur[0];
			}
			next = cur[0] - 1;
			if(next >= 0 && parent[next] == -1) {
				queue.add(new int[] {next, cur[1]+1});
				parent[next] = cur[0];
			}
		}
	}
}
