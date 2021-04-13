package Youtube;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=%EB%B3%B4%EA%B8%89%EB%A1%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1


public class SWEA_1249_보급로 {

	static int N, INF = Integer.MAX_VALUE;
	static int map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}

			System.out.println("#" + t + " " + dijkstra(0, 0));
		}
	}

	private static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(minTime[i], INF);
		}

		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((q1, q2) -> q1[2] - q2[2]);	// PQ 추가
		
		minTime[startR][startC] = 0;
		queue.add(new int[] {startR, startC, minTime[startR][startC]});	// PQ 추가
		
		int r = 0, c = 0, cost = 0, nr, nc;
		int current[];	// PQ 추가
		
		while (true) {
			/*
			// 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
			cost = INF;

			// 이 최소의 정점을 찾는 걸 pq 로 바꿔보자!
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && cost > minTime[i][j]) {
						cost = minTime[i][j];
						r = i;
						c = j;
					}

				}
			}
			*/
			
			// PQ 추가
			current = queue.poll();
			r = current[0];
			c = current[1];
			cost = current[2];

			visited[r][c] = true;
			if (r == N - 1 && c == N - 1)
				return cost;

			// 선택된 정점 기준으로 방문하지 않은 나머지 정점들과 자신과의 경유시의 비용과 기준
			// 최소 비용 비교하여 최솟값 업데이트

			// 현재 정점 위치를 기준으로 4방의 인접정점을 처리
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N 
							&& !visited[nr][nc] && minTime[nr][nc] > cost + map[nr][nc]) {
					minTime[nr][nc] = cost + map[nr][nc];
					queue.add(new int[] {nr, nc, minTime[nr][nc]});
				}
			}
		}
	}

}
