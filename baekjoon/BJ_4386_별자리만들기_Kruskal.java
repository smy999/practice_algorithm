package Dec_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;	
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BJ_4386_별자리만들기 {

	static int N;					// 별 개수
	static double constellationLen;	// 별자리 길이
	static double[][] stars;		// 모든 간선의 길이를 저장하는 배열
	static int[] parent;			// 해당 별의 부모를 저장하는 배열
	static PriorityQueue<Star> pq = new PriorityQueue<Star>((o1, o2) -> (int)(o1.dist - o2.dist));
	static class Star {
		int from, to;
		double dist;
		public Star(int from, int to, double dist) {
			this.from = from; this.to = to; this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		stars = new double[N][2];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		
		// 정점마다 거리를 계산한다.
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				if(i == j) continue;
				pq.add(new Star(i, j, Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2))));
			}
		}
		
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Star star = pq.poll();
			
			int a = find(star.from);
			int b = find(star.to);
			
			if(a != b) {
				union(a, b);
				constellationLen += star.dist;
			}
		}
		
		System.out.printf("%.2f", constellationLen);
	}
	
	// 부모 찾기
	public static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	// 부모가 다르면 이어주기
	public static void union(int a, int b) {
		parent[b] = a;
	}
}
