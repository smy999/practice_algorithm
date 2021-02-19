package hwalgo12;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {
	
	static int R, C, max = 1, cnt;	// 행 수, 열 수, 최대 이동 칸 수, 현재 이동 칸 수
	static char[][] board;		// 입력 배열
	static boolean visit[] = new boolean[26]; // 방문 기록

	// delta: 상 > 우 > 하 > 좌
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][];
		
		for(int i = 0; i < R; i++)	// board 입력
			board[i] = br.readLine().toCharArray();
		
		cnt = 1;	// 시작점에서부터 칸 수 1
		
		move(0, 0);	// 시작점 (0, 0): 좌측 상단
		
		System.out.print(max);	// 최대 칸 수 출력

	}
	
	private static void move(int y, int x) {
		
		visit[board[y][x]-'A'] = true;	// 방문 표시
		
		for(int d = 0; d < 4; d++) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			// 범위 확인, 같은 알파벳이 있는지 확인
			if(nx < 0 || nx >= C || ny < 0 || ny >= R || !check(ny, nx)) continue;
			
			cnt++;	// 카운트 증가 >> 함수 매개변수로 넘겨도 OK
			
			if(max < cnt) max = cnt;	// 최대값 갱신
			
			move(ny, nx);	// 다음 탐색
		}
		cnt--;	// 되돌아 갈 때는 카운트 하나 감소
		visit[board[y][x]-'A'] = false;	// 사방 탐색에서 방문할 곳을 찾지 못했으니 방문 표시 지우로 반환
	}

	private static boolean check(int ny, int nx) {
		if(visit[board[ny][nx]-'A']) return false;	// 해당 알파벳이 있으면 false 반환
		return true;
	}
}
