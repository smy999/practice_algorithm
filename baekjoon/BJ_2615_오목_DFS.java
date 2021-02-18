package com.ssafy.night.algo;

import java.io.*;
import java.util.StringTokenizer;

// 주의: 육목 이상 불가능

public class BJ_2615_오목_DFS {

	// 틀렸던 이유: 개신하는 nr, nc를 매번 체크하지 않으려면 한 칸씩 더 만들어서 0과 비교해야한다.
	static int[][] omok = new int[21][21];		// 입력 바둑판
	static int[][][] memo = new int[21][21][4];	// 방향별 바둑알 개수 기억하는 메모이제이션 배열
	static StringBuilder sb = new StringBuilder();

	// 순서: 우, 우하, 하, 좌하
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input_2615.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 바둑판에 바둑알 위치 입력
		for(int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < 20; j++)
				omok[i][j] = Integer.parseInt(st.nextToken());
		}

		// 승자 판단하는 함수 호출
		System.out.print(isWin());

		// 결과 출력
		System.out.print(sb);

		br.close();	// 스트림 닫기
	}

	/* 다음 바둑알이 같은 바둑알인지 판단하고 같은 바둑알의 개수 판단하는 함수 */
	public static int check(int r, int c, int d, int color) {

		// 새로운 좌표 계산
		int nr = r + dr[d];
		int nc = c + dc[d];

		// 같은 방향의 다음 바둑알이 현재 바둘알과 같다면 1을 더한 후 다음 바둑알을 계산하는 check 호출
		if(omok[nr][nc] == color) return (memo[nr][nc][d] = check(nr, nc, d, color) + 1) ;

		// 같은 방향의 다음 바둑알이 현재 바둑알과 다를 때
		return 1;
	}

	/* 바둑판을 순회하며 정답을 찾는 함수 */
	public static String isWin() {
		// 바둑판 전체 순회
		// 틀렸던 이유: 반복문에서 r부터 비교했다.첫째줄부터 오른쪽으로 비교하기 때문에 열을 증가해가며 비교해야 한다.
		for(int c = 1; c < 20; c++) {	
			for(int r = 1; r < 20; r++) {
				// 바둑알이 존재하는 칸일 때
				if(omok[r][c] != 0) {
					// 4방을 탐색한다.
					for(int d = 0; d < 4; d++) {
						// 이전에 계산한 값이 없고, 해당 위치에서부터 오목이라면 승!
						if(memo[r][c][d] == 0 && check(r, c, d, omok[r][c]) == 5) {
							return omok[r][c] + "\n" + r + " " + c + "\n";
						}
					}
				}
			}
		}
		// 아직 승부가 나지 않았을 때
		return "0";
	}

}
