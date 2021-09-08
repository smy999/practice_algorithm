package Sep_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// MSP(최소스패닝트리)프림, 크루스칼이 있다.

public class BJ_6497_전력난 {

	static int M, N;
	static List<House> list;
	static int[] parent;
	static class House implements Comparable<House> {
		int from, to, dist;
		
		public House(int from, int to, int dist){
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(House h) {
			return dist - h.dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
						
			// 종료 조건
			if(M == 0 && N == 0) break;
			
			list = new ArrayList<House>();
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				list.add(new House(from, to, dist));
				sum += dist;
			}
			
			Collections.sort(list);
			
			// makeset
			parent = new int[M];
			for(int i = 0; i < M; i++) parent[i] = i;
			
			int min = 0;
			for(House house : list) {
				if(findset(house.from) != findset(house.to)) {
					min += house.dist;
					union(house.from, house.to);
				}
			}
			
			// 연결된 거리합 = 드는 비용
			// 전체비용 - 거리합 = 절약된 비용
			sb.append(sum-min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static int findset(int a) {
		if(parent[a] == a) return a;
		return parent[a] = findset(parent[a]);
	}
	
	public static void union(int a, int b) {
		int rootA = findset(a);
		int rootB = findset(b);
		
		if(rootA != rootB) parent[rootB] = rootA;
	}
}
