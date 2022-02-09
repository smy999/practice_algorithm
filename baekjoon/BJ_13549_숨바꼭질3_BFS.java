package Feb_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3_BFS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.print(0);
		} else if(N > K) {
			System.out.print(N-K);
		} else {
			// 이전 숨바꼭질2에서는 이동하는데 시간이 모두 1초만큼 증가했지만,
			// 숨바꼭질3에서는 순간이동에 0초이기 때문에 PQ 자료구조를 사용했다.
			PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[1]-p2[1]);
			boolean[] visited = new boolean[100001];
			queue.offer(new int[] {N, 0});
			visited[N] = true;
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				visited[cur[0]] = true;
				
				if(cur[0] == K) {
					System.out.print(cur[1]);
					return;
				}
				
				int next = cur[0]+1;
				if(next <= 100000 && !visited[next]) queue.offer(new int[] {next, cur[1]+1});
				next = cur[0]*2;
				if(next <= 100000 && !visited[next]) queue.offer(new int[] {next, cur[1]});
				next = cur[0]-1;
				if(next >= 0 && !visited[next]) queue.offer(new int[] {next, cur[1]+1});
			}
		}
	}
}
