package workshop;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {

	static int T, N, min;	// 
	static int[][] loc;		// 고객 배열
	static int[][] point = new int[2][2]; // 시작점, 종점 배열
	static int[] route;
	static boolean[] visited;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input_1247.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;	// 틀린 이유1: 0으로 초기화했었다.
			
			N = Integer.parseInt(br.readLine());

			loc = new int[N][2];
			route = new int[N];
			visited = new boolean[N];

			st = new StringTokenizer(br.readLine());

			point[0][0] = Integer.parseInt(st.nextToken());	// 회사
			point[0][1] = Integer.parseInt(st.nextToken());
			point[1][0] = Integer.parseInt(st.nextToken()); // 집
			point[1][1] = Integer.parseInt(st.nextToken());

			for(int i = 0; i < N; i++) {
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);
			
			sb.append("#" + t +" " + min + "\n");
		}
		System.out.print(sb);
	}

	public static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	public static void dfs(int idx, int sum) {
		// prunning 후처리
		if(min <= sum) return;

		// 모든 고객의 집을 방문했을 때
		if(idx == N) {
			//고객에서 집으로 갈 때
			sum += getDistance(loc[route[N-1]][0], loc[route[N-1]][1], point[1][0], point[1][1]);
			// 최대값 갱신
			if(min > sum) min = sum;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;	// 선택
			
			route[idx] = i;
			
			// 회사에서 출발할 때, 고객에서 출발할 때
			int dist = 0;
			if(idx == 0) dist = getDistance(point[0][0], point[0][1], loc[route[0]][0], loc[route[0]][1]);
			else dist = getDistance(loc[route[idx-1]][0], loc[route[idx-1]][1], loc[i][0], loc[i][1]);
			
			dfs(idx+1, sum + dist);	// 다음 경로 탐색
			
			visited[i] = false;	// 비선택
		}
	}
}
