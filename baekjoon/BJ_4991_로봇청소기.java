package Dec_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class BJ_4991_로봇청소기 {

	// 행, 열, 로봇 + 더러운 칸 개수, 청소 가능한 더러운 칸 개수, 총 이동 횟수(거리)
	static int h, w, size, dirtyCnt, moveCnt;
	static char[][] room;				// 입력 배열
	static int[][] dist;				// 거리 배열
	static boolean[][] visited;			// 방문 배열 - 모든 거리 구하기
	static boolean[] visited2;			// 방문 배열 - 최단 거리 구하기
	static int[] dr = {-1, 0, 1, 0};	// 사방탐색
	static int[] dc = {0, 1, 0, -1};
	static List<Node> list;				// 로봇 + 더러운 칸 리스트
	static class Node {					// 칸과 이동거리 정보 저장 클래스
		int r, c, cnt;
		public Node(int r, int c, int cnt) {
			this.r = r; this.c = c; this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			// 방 크기 입력
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 종료 조건
			if(h == 0 && w == 0) break;
			
			room = new char[h][w];
			list = new ArrayList<>();
			
			// 입력
			for(int i = 0 ; i < h; i++) {
				room[i] = br.readLine().toCharArray();
				for(int j = 0; j < w; j++) {
					// 시작(로봇) 위치 찾기
					if(room[i][j] == 'o') list.add(0, new Node(i, j, 0));
					// 더러운 칸 찾기
					else if(room[i][j] == '*') list.add(new Node(i, j, 0));
				}
			}
		
			size = list.size();	// 로봇, 더러운 칸 개수 저장
			
			// 로봇, 더러운 칸 거리 구하기
			dist = new int[size][size];
			dirtyCnt = 0;
			for(int i = 0; i < size; i++) {
				bfs(list.get(i), i);
			}
			
			// 모든 더러운 칸을 청소할 수 있는 경우
			if(dirtyCnt == size-1) {
				moveCnt = Integer.MAX_VALUE;
				
				// 최단 경로 계산하기
				visited2 = new boolean[size];	// 최단 거리 방문 배열
				visited2[0] = true;				// 로봇은 시작위치이기 때문에 true
				move(0, 1, 0);
				
				sb.append(moveCnt).append("\n");
			} else { // 더러운 칸을 하나라도 청소하지 못할 경우
				sb.append(-1).append("\n");
			}
		}
		
		System.out.print(sb);
	}
	
	// 로봇, 더러운 칸 거리 구하는 함수
	// node: 탐색 시작 노드, start: 탐색 시작 노드의 인덱스(list)
	public static void bfs(Node node, int start) {
		// node와 모든 더러운 칸의 거리를 구한다.
		// 아래의 queue와 visited는 한 node에서 갈 수 있는 모든 더러운 칸과의 거리를 구하는데 사용된다.
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		visited = new boolean[h][w];
		visited[node.r][node.c] = true;
		
		while(!queue.isEmpty()) {
			Node next = queue.poll();
			
			// 더러운 칸을 찾았을 때
			if(room[next.r][next.c] == '*') {
				// 로봇에서 출발하는 경우, 새로운 더러운 칸이 나올 때마다 개수를 증가시킨다.
				// (더러운 칸을 모두 청소할 수 있는지 아닌지 판단하기 위함)
				if(start == 0) dirtyCnt++;
				
				// 거리 구하기
				for(int i = 1; i < size; i++) {
					// 현재 위치인 더러운 칸이 list에서 어느 index인지 찾아서 거리 배열을 갱신한다.
					if(next.r == list.get(i).r && next.c == list.get(i).c) {
						dist[start][i] = next.cnt;
					}
				}
			}
			
			// 현재 위치가 더러운 칸이 아닐 땐 계속 탐색
			for(int d = 0; d < 4; d++) {
				int nr = next.r + dr[d];
				int nc = next.c + dc[d];
				
				if(nr < 0 || nr >= h || nc < 0 || nc >= w 
						|| room[nr][nc] == 'x' || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				queue.add(new Node(nr, nc, next.cnt+1));
			}
		}
		
	}

	// 최단 거리 구하는 함수 - 재귀함수이기 때문에 모든 경우의 수에서 최단 이동 횟수를 구한다.
	public static void move(int start, int cleanCnt, int cnt) {
		if(cleanCnt == size) moveCnt = Math.min(moveCnt, cnt);
		
		for(int i = 0; i < size; i++) {
			if(!visited2[i]) {	// 아직 청소하지 않은 곳이 있다면 이동
				visited2[i] = true;
				move(i, cleanCnt+1, cnt+dist[start][i]);
				visited2[i] = false;
			}
		}
	}


}
