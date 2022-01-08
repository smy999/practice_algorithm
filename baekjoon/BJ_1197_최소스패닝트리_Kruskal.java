package Jan_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_1197_최소스패닝트리_Kruskal {
	
	static int[] parents;		// union-find를 위한 부모 배열
	static class Edge {			// 간선 정보 저장
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> edgeList = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 가중치를 오름차순으로 정렬해서 가중치가 작은 순으로 간선을 연결한다.
		Collections.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);
		
		// make:  각 정점이 속한 트리의 부모를 표시하는 배열
		parents = new int[V+1];
		for(int i = 1; i <= V; i++) parents[i] = i;
		
		int eCnt = 0, wSum = 0; 
		
		for(Edge edge : edgeList) {
			// find: 부모가 다른 애들 찾기 = 미연결 정점을 찾는다.
			// union: 미연결 정점을 찾아 연결
			if(union(edge.from, edge.to)) {
				eCnt++;
				wSum += edge.weight;
			}
			if(eCnt == V-1) break;
		}
		
		System.out.print(wSum);
	}
	
	public static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		// 오류원인: int aRoot = parent[a];라고 작성함. union-find 코드를 잘 보자.
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
