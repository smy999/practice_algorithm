package hwalgo21_서울_13반_서민영;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA_1251_하나로_Kruskal {

	static int T, N;
	static double E, min;
	static int[][] loc;
	static Node[] list;
	static int[] parent;
	
	// 자료구조: 출발, 도착, 가충치 
	static class Node implements Comparable<Node>{
		int from, to;
		double dist;
		public Node(int from, int to, double dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node node) {
			return Double.compare(this.dist, node.dist);
		}
		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", dist=" + dist + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());	// 섬의 수
			
			// line 51~57: loc[i][0] = x좌표, loc[i][1] = y좌표 형식으로 저장
			loc = new int[N][2];	
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) loc[i][0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) loc[i][1] = Integer.parseInt(st.nextToken());
			
			E = Double.parseDouble(br.readLine());	// 환경 부담금
			
			list = new Node[N*N];	// 노드, 간선 정보 저장 배열
			
			// line 64~72: 노드, 간선 정보 저장 
			int idx = 0;
			for (int i = 0; i < N; i++) {
				int x1 = loc[i][0], y1 = loc[i][1];
				for (int j = 0; j < N; j++) {
					int x2 = loc[j][0], y2 = loc[j][1];
					double d = (double) Math.pow(x1 - x2, 2) + (double) Math.pow(y1 - y2, 2);
					list[idx++] = new Node(i, j, d);
				}
			}
			
			// 간선 가중치 오름차순 정렬
			Arrays.sort(list);
			
			// 부모가 자신인 단위 집합 만들기
			parent = new int[N];
			make();
			
			int cnt = 0;	// Node 저장 배열 인덱스
			min = 0;		// 최소값(결과)
			
			// line 84~90: Union-Find를 통한 최소값 구하기
			for(Node node : list) {
				if(node.dist == 0) continue;
				if(unionSet(node.from, node.to)) {
					min += node.dist;
				}
			}
			
			// 경로에 세율 곱해 최소 환경 부담금 구하기
			min *= E;

			sb.append("#" + t + " " + Math.round(min) + "\n");
			
		} // for: T
		
		// 결과 출력
		System.out.print(sb);
		
	} // func: main
	
	
	public static void make() {
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
	} // func: make
	
	public static int findSet(int a) {
		if(parent[a] == a) return a;
		return parent[a] = findSet(parent[a]);
	} // func: findSet
	
	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	} // func: unionSet	
}
