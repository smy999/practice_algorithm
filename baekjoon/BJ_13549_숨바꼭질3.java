package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 수빈이의 위치
		int K = Integer.parseInt(st.nextToken());	// 동생의 위치
		
		boolean[] visited = new boolean[100001];
		
		// 정렬 이런 방법도 있다.
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
		pq.add(new int[] {N, 0});
		
		while(!pq.isEmpty()) {
			int[] su = pq.poll();
			visited[su[0]] = true;	// 꺼낼 때 방문표시
			
			// 우선순위큐 >> 나오면 바로 출력하고 
			if(su[0] == K) {
				System.out.print(su[1]);
				break;
			}
			
			// 주의: 순간이동은 0
			if(su[0]+1 <= 100000 && !visited[su[0]+1]) pq.add(new int[] {su[0]+1, su[1]+1});
			if(su[0]-1 >= 0 && !visited[su[0]-1]) pq.add(new int[] {su[0]-1, su[1]+1});
			if(su[0]*2 <= 100000 && !visited[su[0]*2]) pq.add(new int[] {su[0]*2, su[1]});
		}
	}
}
