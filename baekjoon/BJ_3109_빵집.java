package workshop;

import java.io.*;
import java.util.*;

public class BJ_3109_빵집 {

	static int R, C, pipe;		// 행, 열, 파이프 설치 수
	static char[][] input;		// 입력 배열
	static boolean[][] visit;	// 방문 확인 배열

	// 델타 순서 중요하다. 상>중>하 순으로 가야 최대 파이프 설치 수를 구할 수 있다.
	static int[] dr = {-1, 0, 1};	
	// static int[] dc = {1, 1, 1};	// 다 1인데 굳이 배열 선언해서 일 시키지 마

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		input = new char[R][C];
		visit = new boolean[R][C];

		for(int i = 0; i < R; i++)
			input[i] = br.readLine().toCharArray();

		for(int i = 0; i < R; i++)
			install(i, 0);
		
		System.out.print(pipe);
	}

	public static boolean install(int rowNo, int colNo) {

		visit[rowNo][colNo] = true;	// 현재 위치 방문 표시

		if(colNo == C-1) {
			pipe++;
			return true;
		}

		for(int d = 0; d < 3; d++) {
			int nr = rowNo + dr[d];
			int nc = colNo + 1;

			if(nr < 0 || nr >= R || input[nr][nc] !='.' || visit[nr][nc]) continue;

			if(install(nr, nc)) return true;
			
			// [오답] visit을 되돌리지 않는 이유 
			// : 이 길로 가봤자 파이프 설치 못 해. 그래서 되돌리면 시간 초과! 기껏 탐색한 거 왜 되돌려!
			// else visit[nr][nc] = false;
		}

		return false;
	}
}
