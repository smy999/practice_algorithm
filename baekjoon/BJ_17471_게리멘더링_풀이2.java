package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class BJ_17471_게리멘더링 {

	static int N, min = Integer.MAX_VALUE;
	static boolean[] district;
	static int[] population;
	static int[][] adjMatrix;
	static LinkedList<Integer> dist = new LinkedList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		adjMatrix = new int[N+1][N+1];
		for(int n1 = 1; n1 <= N; n1++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int i = 0; i < size; i++) {
				int n2 = Integer.parseInt(st.nextToken());
				adjMatrix[n1][n2] = adjMatrix[n2][n1] = 1;
			}
		}
		
		district = new boolean[N+1];
		
		divide(1);
		
		if(min == Integer.MAX_VALUE) System.out.print(-1);
		else System.out.print(min);
		
	}
	
	private static void divide(int idx) {
		if(idx > N) {
			if(isLinked(true) && isLinked(false)) min = Math.min(min, getDiffer());
			return;
		}
		
		district[idx] = true;
		divide(idx+1);
		district[idx] = false;
		divide(idx+1);
	}
	
	private static boolean isLinked(boolean flag) {		
		
		visited = new boolean[N+1];

		for(int i = 1; i <= N; i++) {
			if(district[i] == flag) {
//				dist.addLast(i);
				dist.add(i);
				visited[i] = true;
				break;
			}
		}

		while(!dist.isEmpty()) {
//			int node = dist.pollFirst();
			int node = dist.poll();
			
			for(int i = 1; i <= N; i++) {
				if(adjMatrix[node][i] == 0 || visited[i] || district[i] != flag) continue;
//				dist.addLast(i);
				dist.add(i);
				visited[i] = true;
			}
		}

		for(int i = 1; i <= N; i++) {
			if(district[i] == flag && !visited[i]) return false;
		}
		
		return true;
	}
	
	
	private static int getDiffer() {
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 1; i <= N; i++) {
			if(district[i]) sum1 += population[i];
			else sum2 += population[i];
		}
		
		return Math.abs(sum1-sum2);
	}
	
}



/*
참고
https://m.blog.naver.com/PostView.nhn?blogId=whiteflower_&logNo=221654118935&categoryNo=8&proxyReferer=https:%2F%2Fwww.google.com%2F
*/
