package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class BJ_5972_택배배송_PQ {
	
	static class Barn implements Comparable<Barn>{
		int idx, dist;
		public Barn(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		@Override
		public int compareTo(Barn barn) {
			if(this.dist < barn.dist) return -1;
			return 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Barn>> map = new ArrayList<>();	// 입력 배
		
		for(int i = 0; i < N+1; i++) {
			map.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map.get(n1).add(new Barn(n2, cost));
			map.get(n2).add(new Barn(n1, cost));

		}
		
//		boolean visited[] = new boolean[N+1];	// 방문 확인 배
		
		
		int dist[] = new int[N+1];	// 최단거리 저장 배열
		Arrays.fill(dist, Integer.MAX_VALUE);		
		dist[1] = 0;
		
		PriorityQueue<Barn> pqueue = new PriorityQueue<>();
		pqueue.add(new Barn(1, 0));
		
		while(!pqueue.isEmpty()) {
			Barn barn = pqueue.poll();
			int index = barn.idx;
			int distance = barn.dist;
			
			if(dist[index] < distance) continue;
			
			for(int i = 0; i < map.get(index).size(); i++) {
				int cost = dist[index] + map.get(index).get(i).dist;
				if(cost < dist[map.get(index).get(i).idx]) {
					dist[map.get(index).get(i).idx] = cost;
					pqueue.add(new Barn(map.get(index).get(i).idx, cost));
				}
			}
		}
		
		System.out.print(dist[N]);
		
	}

}
