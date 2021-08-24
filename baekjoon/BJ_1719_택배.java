package Aug_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_1719_택배 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static class Node implements Comparable<Node> {
		int idx, cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		// 정보 입력
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, cost));
			list.get(to).add(new Node(from, cost));
		}
		
		// 집하장별 경로 계산
		for(int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		
		System.out.println(sb);
		
	}
	
	public static void dijkstra(int from) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(from, 0));
		
		boolean[] visited = new boolean[N+1];
		int[] pathArr = new int[N+1];
		int[] costArr = new int[N+1];
		
		Arrays.fill(costArr, Integer.MAX_VALUE);
		
		costArr[0] = 0;
		pathArr[from] = from;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int curIdx = node.idx;
			int curCost = node.cost;
			
			if(visited[curIdx]) continue;
			
			visited[curIdx] = true;
			
			for(int i = 0; i < list.get(curIdx).size(); i++) {
				int costTmp = costArr[curIdx] + list.get(curIdx).get(i).cost;
				
				int indexTmp = list.get(curIdx).get(i).idx;
				
				if(costTmp < costArr[indexTmp]) {
					costArr[indexTmp] = costTmp;
					pathArr[indexTmp] = curIdx;
					pq.add(new Node(indexTmp, costTmp));
				}
			}
		}
		
		findPath(from, pathArr);
	}
	
	// 결과 문자열로 합치기
	public static void findPath(int from, int[] pathArr) {
		for(int i = 1; i <= N; i++) {
			if(i == from) {
				sb.append("- ");
				continue;
			}
			int cost = 0;
			// 다음 경로 찾아가기
			for(int j = i; j != from; j = pathArr[j]){
				cost = j;
			}
			sb.append(cost + " ");
		}
		sb.append("\n");
	}
}
