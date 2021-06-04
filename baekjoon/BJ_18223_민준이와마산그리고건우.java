package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18223_민준이와마산그리고건우 {
	
	static int V, E, P;
	static ArrayList<Node>[] map;
	static PriorityQueue<Node> pq;
	static class Node implements Comparable<Node>{
		int n2, cost;
		public Node(int n2, int cost) {
			this.n2 = n2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node node) {
			if(this.cost < node.cost) return -1;
			return 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		// 입력 list 준비
		map = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			map[i] = new ArrayList<>();
		}
		
		// 노드와 간선 정보 입력
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			// 양방향
			map[n1].add(new Node(n2, cost));
			map[n2].add(new Node(n1, cost));
		}
		
		int[] distM = dijkstra(1);		// M(민준)부터 V까지
		int[] distP = dijkstra(P); 		// P(건우)부터 V까지
		
		// 민준이가 건우를 도와주는 경로의 길이(distM[P] + distP[V])가
		// 최단 경로의 길이(distM)보다 
		// 길어지지 않는다면 민주이는 건우를 도와준다.
		if(distM[V] >= distM[P] + distP[V]) System.out.print("SAVE HIM");
		else System.out.print("GOOD BYE");
		
	}
	
	// 인자로 전달된 노드부터 마지막 노드까지의 최단거리를 구하는 함수
	public static int[] dijkstra(int n1) {
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		pq = new PriorityQueue<>();
		pq.add(new Node(n1, 0));
		dist[n1] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			for(Node temp: map[node.n2]) {
				if(dist[temp.n2] > temp.cost + node.cost) {
					dist[temp.n2] = temp.cost + node.cost;
					pq.add(new Node(temp.n2, dist[temp.n2]));
				}
			}
		}
		
		return dist;
	}
 
}
