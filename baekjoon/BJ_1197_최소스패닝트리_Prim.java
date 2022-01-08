package Jan_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class BJ_1197_최소스패닝트리_Prim {

	// 간선정보 저장 클래스
	public static class Edge{
		int vertex;
		int weight;
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge>[] edgeList = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			edgeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[vertex1].add(new Edge(vertex2, weight));
			edgeList[vertex2].add(new Edge(vertex1, weight));
		}
		
		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<Edge> pQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		pQueue.add(new Edge(1, 0));
		
		int eCnt = 0, wSum = 0;
		
		while(!pQueue.isEmpty()) {
			Edge edge = pQueue.poll();
			
			if(visited[edge.vertex]) continue;
			
			// Edge: 신장 트리에 연결되지 않은 정점 중 비용이 최소인 정점
			visited[edge.vertex] = true;
			wSum += edge.weight;
			eCnt++;
			
			// MST는 정점의 개수 V, 간선의 개수 V-1인데 왜 eCnt == V로 비교를 하는가?
			// 위에서 pQueue의 초기값으로 Edge(1, 0)을 넣었기 때문에 
			// 자기자신으로의 경로가 하나더 포함되어서 간선의 개수에 하나를 더해서 종료조건을 설정한다.
			if(eCnt == V) break;
			
			// 현재 간선을 추가한 정점과 연결된 간전 정보 저장
			for(Edge e : edgeList[edge.vertex]) {
				if(!visited[e.vertex]) pQueue.add(e);
			}
		}
		
		System.out.print(wSum);
	}
}
