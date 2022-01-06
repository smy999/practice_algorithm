package Jan_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1916_최소비용구하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[N+1][N+1];
		// 0으로 알아서 들어가는 -1로 초기값 설정을 해주는 이유는?
		// 버스요금이 0원인 경우도 있기 때문에 연결되지 않은 부분을 표시하기 위해 -1로 초기화
		for(int i = 1; i <= N; i++) {
			Arrays.fill(adjMatrix[i], -1);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			// 굳이 분기해서 넣어주는 이유?
			// from to 쌍이 중복되어 들어오고 버스요금만 다른 입력값이 있을 수 있다.
			if(adjMatrix[from][to] == -1) adjMatrix[from][to] = cost;
			else adjMatrix[from][to] = Math.min(adjMatrix[from][to], cost);
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] cost = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		
		for(int i = 1; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			
			for(int j = 1; j <= N; j++) {
				if(!visited[j] && min > cost[j]) {
					idx = j;
					min = cost[j];
				}
			}
			
			visited[idx] = true;
			if(idx == end) break;	// 목표하는 도시까지의 최단거리를 구하면 더이상 수행할 필요가 없다. = 시간단축
			
			for(int j = 1; j <= N; j++) {
				if(!visited[j] && adjMatrix[idx][j] != -1 && cost[idx] != Integer.MAX_VALUE && min + adjMatrix[idx][j] < cost[j]) {
					cost[j] = min + adjMatrix[idx][j];
				}
			}
		}
		
		System.out.print(cost[end]);
	}
}
