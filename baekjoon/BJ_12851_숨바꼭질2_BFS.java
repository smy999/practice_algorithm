package Feb_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_12851_숨바꼭질2_BFS {

	static int N, K, min=Integer.MAX_VALUE, cnt=0;
	static boolean[] visited = new boolean[100001];
	static PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p1-p2);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.print(0 + "\n" + 1);
		} else if(N > K) {
			System.out.print(N-K + "\n" + 1);
		} else {
			bfs();
			System.out.print(min + "\n" + cnt);
		}
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N, 0});
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			visited[cur[0]] = true;
			
			if(cur[0] == K) {
				min = Math.min(min, cur[1]);
				if(min != cur[1]) break;
				cnt++;
			}
			
			int next = cur[0]+1;
			if(next <= 100000 && !visited[next]) {
				queue.add(new int[] {next, cur[1]+1});
			}
			next = cur[0]*2;
			if(next <= 100000 && !visited[next]) {
				queue.add(new int[] {next, cur[1]+1});
			}
			next = cur[0]-1;
			if(0 <= next && !visited[next]) {
				queue.add(new int[] {next, cur[1]+1});
			}
		}
	}
}
