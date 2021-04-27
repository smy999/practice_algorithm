// https://geunzrial.tistory.com/85

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_1774_우주신과의교감 {
	
	static int N, M;
	static Pos[] position;
	static int[] parent;
	static ArrayList<Edge> edge = new ArrayList<>();
	static class Pos{
		int no;
		double r, c;
		public Pos(int no, double r, double c) {
			this.no = no;
			this.r = r;
			this.c = c;
		}
	}
	static class Edge implements Comparable<Edge> {
		int node1, node2;
		double dist;
		public Edge(int node1, int node2, double dist) {
			this.node1 = node1;
			this.node2 = node2;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge e) {
			return this.dist > e.dist ? 1 : -1;
		}
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		position = new Pos[N+1];
		
		// 좌표 정보 입력
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			position[i] = new Pos(i, r, c);
		}
		
		// union-find를 위한 parent 배열 초기화
		parent = new int[N+1];
//		make();
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		// 입력으로 들어온 연결된 점들 연결 표시하기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			// 이미 연결되었을 때 다음 노드 탐색
			if(findSet(node1) == findSet(node2)) continue;
			
			// 연결 표시
			unionSet(node1, node2);
		}
		
		// 연결된 노드 간의 거리 구하기
		for(int i = 1; i <= N; i++) {
			for(int j = i+1; j <= N; j++) {
				double dist = Math.sqrt(Math.pow(position[i].r - position[j].r, 2) 
						+ Math.pow(position[i].c - position[j].c, 2));
				edge.add(new Edge(position[i].no, position[j].no, dist));
			}
		}
		
		Collections.sort(edge);
		
		double minDist = 0;
		for(int i = 0; i < edge.size(); i++) {
			Edge e = edge.get(i);
			if(findSet(e.node1) != findSet(e.node2)) {
				minDist += e.dist;
				unionSet(e.node1, e.node2);
			}
		}
		System.out.print(String.format("%.2f", minDist));
	}
	
	private static void make() {
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int a) {
		if(parent[a] == a) return a;
		return parent[a] = findSet(parent[a]);
	}

	private static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot > bRoot) parent[aRoot] = bRoot;
		else parent[bRoot] = aRoot;
	}
}
