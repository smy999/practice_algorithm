package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_3055_탈출_BFS {

	static int R, C, minT;				// 숲 크기, 최단 시간
	static char[][] forest;				// 숲 배열
	static boolean arrivable;			// 도착 가능 여부
	static Queue<int[]> hedgehogQ = new LinkedList<>();	// 고슴도치 = 헤지하그
	static Queue<int[]> waterQ = new LinkedList<>();	// 물
	static int[] dr = {-1, 0, 1, 0};	// 물과 고슴조치 모두 상하좌우로 이동 가능
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		forest = new char[R][C];	// 숲 배열 생성
		
		// 숲 입력
		boolean findS = false;		// 초기 고슴도치의 위치를 찾았는지 확인하는 변
		for(int i = 0; i < R; i++) {
			// 행 정보 입력
			forest[i] = br.readLine().toCharArray();
			// 초기 물의 위치 저장
			for(int j = 0; j < C; j++) {	
				if(forest[i][j] == '*') waterQ.add(new int[] {i, j});
			}
			// 초기 고슴도치의 위치 저장
			if(findS) continue;	
			for(int j = 0; j < C; j++) {
				if(forest[i][j] == 'S') {
					findS = true;
					hedgehogQ.add(new int[] {i, j});
				}
			}
		}
		
		bfs();
		
		if(arrivable) System.out.print(minT);
		else System.out.print("KAKTUS");
	}
	
	public static void bfs() {
		// 고슴도치가 더이상 갈 곳이 없을 때까지 진행 >> 한번 실행될 때마다 1분
		while(!hedgehogQ.isEmpty()) {
			// 1분마다 시간 증가
			minT++;
			
			// 물 채우기
			int sizeW = waterQ.size();
			if(sizeW > 0) {
				for(int i = 0; i < sizeW; i++) {
					int[] water = waterQ.poll();
					for(int d = 0; d < 4; d++) {
						int nr = water[0] + dr[d];
						int nc = water[1] + dc[d];
						
						// 범위를 벗어나거나, 벽을 만나면 다음 방향 탐색
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || forest[nr][nc] != '.') continue;
						
						forest[nr][nc] = '*';	// 숲 배열에 바로 방문 표시
						waterQ.add(new int[] {nr, nc});
					}
				}
			}
			
			// 고슴도치 이동
			int sizeH = hedgehogQ.size();
			if(sizeH > 0) {
				for(int i = 0; i < sizeH; i++) {
					int[] hedgehog = hedgehogQ.poll();
					for(int d = 0; d < 4; d++) {
						int nr = hedgehog[0] + dr[d];
						int nc = hedgehog[1] + dc[d];
						
						// 범위를 벗어나거나, 물과 벽을 만나면 다음 방향 탐색
						// forest[nr][nc] == 'S' >> 오류 이유 아래서 방문표시를 했지만 이부분에서 검사를 하지 않아 중복 검사가 진행
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || forest[nr][nc] == 'X' || forest[nr][nc] == '*' || forest[nr][nc] == 'S') continue;
						
						// 비버의 굴에 도착했을 떄
						if(forest[nr][nc] == 'D') {
							arrivable = true;
							return;
						}
						
						forest[nr][nc] = 'S';	// 숲 배열에 바로 방문 표시
						hedgehogQ.add(new int[] {nr, nc});
					}
				}
			}
		}
		
	}
}
