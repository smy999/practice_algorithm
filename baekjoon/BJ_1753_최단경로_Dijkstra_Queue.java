package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ_1753_최단경로_Dijkstra_Queue {

	static int V, E, start;
	static ArrayList<int[]>[] list;
	static PriorityQueue<int[]> pQueue = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list[node1].add(new int[] {node2, dist});
		}
		
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pQueue.add(new int[] {start, 0});
		
		while(!pQueue.isEmpty()) {
			int[] temp = pQueue.poll();
			int current = temp[0];
			
			if(visited[current]) continue;
			visited[current] = true;
			
			for(int[] node : list[current]) {
				if(distance[node[0]] > (distance[current] + node[1])) {
					distance[node[0]] = distance[current] + node[1];
					pQueue.add(new int[] {node[0], distance[node[0]]});
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(distance[i] + "\n");
		}
		
		System.out.println(sb);
	}
}
