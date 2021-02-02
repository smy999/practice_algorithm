package hwalog02;

import java.util.Scanner;

public class SWEA_1954 {
	static int T, N, curX, curY, cnt;	// testcase, array size, 현재 column, 현재 row, 방향 카운트
	static int[][] snail;				// 달팽이 배열 선언

	static int[] dx = {1, 0, -1, 0};	// delta: 우, 하, 좌, 상
	static int[] dy = {0, 1, 0, -1};
	// 참고: 방향 설정 방법
	// 1. 방향을 카운트하며(범위를 벗어나거나 이미 값이 존재하는 위치일 떄 cnt를 증가시킨다.)
	// 2. cnt값을 4로 나눈 나머지가 dy, dx의 index 값이다.
	// 나머지로 하는 이유는 모든 방향을 한 바퀴 돌고 나서도 배열의 크기가 크면 몇 바퀴고 더 돌 것이기 때문에
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();					// testcase 입력
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();				// 배열 크기 입력
			snail = new int[N][N];			// 입력 크기만큼 배열 생성
			
			curX = 0; curY = 0; cnt = 0;	// 초기 위치(0, 0), 초기 값(0)
			for(int n = 0; n < N*N; n++) {	
				snail[curY][curX] = n+1;	// 현재 위치에 값 넣기
				int nc = curX + dx[cnt%4];	// 같은 방향으로 한 칸 이동할 좌표 계산
				int nr = curY + dy[cnt%4];
				
				// 범위를 벗어나거나 이미 방문한 위치이면 방향을 바꾼 후 한 칸 이동한다.
				if(nc < 0 || nc >= N || nr < 0 || nr >= N || snail[nr][nc] != 0) {	
					cnt++;
					curX = curX + dx[cnt%4];
					curY = curY + dy[cnt%4];
				}else{	// 아니면 원래 방향으로 한 칸 이동한다.
					curX = nc; curY = nr;
				}
			}
			
			System.out.println("#" + t);	// testcase별 출력
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N; j++)
					System.out.print(snail[i][j] + " ");
				System.out.println();
			}
		}
	}
}
