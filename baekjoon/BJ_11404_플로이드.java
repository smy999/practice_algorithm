package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드: 모든 최단 경로 구하기, 음의 가중치 가능
// 경유하면서 모든 경우 판단.
// 다익스트라: 빠름, 가중치 양수만 가능
// 벨만포드: 중간, 가중치가 음수일 때 다익스트라 대신 사용
// 플로이드: 느림, 가중치가 음수일 때 사용 가능

public class BJ_11404_플로이드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] city = new int[N+1][N+1];
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) { 
			for(int j = 1; j <= N; j++) {
				if(i == j) city[i][j] = 0;
				else city[i][j] = 9999999;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			// 단방향
			city[from][to] = Math.min(city[from][to], cost);
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(k == i) continue;
				for(int j = 1; j <= N; j++) {
					if(i == j || j == k) continue;
					// 최소비용 갱신
					city[i][j] = Math.min(city[i][k]+city[k][j], city[i][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(city[i][j] >= 9999999) sb.append("0").append(" ");
				else sb.append(city[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
