package hwalgo22_서울_13반_서민영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 실패 원인1: 하나하나 50씩 빼가면서 병의 개수를 계산했다. (편의점을 순서대로 방문해야한다고 멋대로 가정함)
// 실패 원인2: 확인 출력 주석 처리 안해서. 잊지말자.
// 해결 방법: 모든 정점을 방문하여 가능 여부를 파악하는 방법으로 해결(floyd-warshall)

// 배열이 더 빨랐다.

public class BJ_9205_맥주마시면서걸어가기 {

	static int T, N; // 테스트케이스, 편의점 개수
	static int[][] map, arr; // 좌표 저장 배열, DP 배열(각 정점으로 갈 수 있는 경로 수)
	// static ArrayList<Location> list = new ArrayList<>(); 
	
	static class Location {
		int x, y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			// arr(DP 배열): 모든 간선을 999999로 초기화
			arr = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					// if(i==j) arr[i][j] = 0;
					// else arr[i][j] = 999999;
					arr[i][j] = 999999;
				}
			}

			// 좌표 정보 받아오기: 상구네, 편의점, 페스티벌 (총 N+2개)
			map = new int[N + 2][2];
			// list = new ArrayList<>();
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
				// list.add(new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == j)
						continue;

					// 맨해튼 거리 계산
					int dist = Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]);
					// int dist = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);

					if (dist <= 1000) // 1000의 의미: 20병*50미터
						arr[i][j] = 1; // 가는 길에 맥주가 부족하지 않으면 간선으로 연결
				}
			}

			// floyd-warshall algorithm
			for (int k = 0; k < N + 2; k++) {
				// 출력 구분선
				// System.out.println();
				// System.out.println("--------------------------------------");
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < N + 2; j++) {
						if (arr[i][j] > arr[i][k] + arr[k][j])
							arr[i][j] = arr[i][k] + arr[k][j];
					}
					// 확인 출력
					// System.out.println(Arrays.toString(arr[i]));
				}
			}

			// 1번째(인덱스: 0)에서 마지막(인덱스: N+1)로 가는 경로 수가 999999보다 작으면 맥주가 떨어지지 않고 페스티벌에 도착 가능
			if (arr[0][N + 1] < 999999)
				sb.append("happy" + "\n");
			else
				sb.append("sad" + "\n");

		}
		System.out.print(sb);
	}
}
