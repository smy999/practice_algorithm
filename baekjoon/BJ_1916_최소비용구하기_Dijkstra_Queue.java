import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

// 다익스트라
// 특정 노드에서 출발해서 다른 노드로 가는 최단경로
// 음의 간성이 없다.

public class BJ_1916_최소비용구하기_Queue {

	static int N, M, start, end;
	static int[] dijkstra;
	static ArrayList<ArrayList<Info>> list = new ArrayList<>();
	static PriorityQueue<Info> pq = new PriorityQueue<>();
	static class Info implements Comparable<Info>{
		int c, cost;
		public Info(int c, int cost) {
			this.c = c;
			this.cost = cost;
		}
		// 짧은 순으로 정렬
		@Override
		public int compareTo(Info info) {
			if(this.cost < info.cost) return -1;
			return 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Info>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(from).add(new Info(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra = new int[N+1];
		Arrays.fill(dijkstra, Integer.MAX_VALUE);
		
		// 시작점에서 거리 0으로 시작
		dijkstra[start] = 0;
		pq.offer(new Info(start, 0));
		
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			int idx = info.c;
			int cost = info.cost;
			
			// 현재 다익스트라 배열의 값이 더 작으면 갱신할 필요 X
			if(dijkstra[idx] < cost) continue;
			
			// 최소값 갱신, 현재 위치에서 갈 수 있는 모든 곳을 탐색하면서 값이 더 작으면 갱신
			for(int i = 0; i < list.get(idx).size(); i++) {
				int idx2 = list.get(idx).get(i).c;
				int cost2 = dijkstra[idx] + list.get(idx).get(i).cost;
				if(cost2 < dijkstra[idx2]) {
					dijkstra[idx2] = cost2;
					pq.offer(new Info(idx2, cost2));
				}
			}
		}

		System.out.print(dijkstra[end]);
		br.close();
	}
}
