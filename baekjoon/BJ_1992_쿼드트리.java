package hwalgo11;

import java.io.*;

public class BJ_1992_쿼드트리 {

	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		String str;

		for(int i = 0; i < N; i++) {	// 배열 입력
			str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		quadTree(0, 0, N);		// 재귀(분할정복) 함수 호출

		System.out.println(sb);	// 결과 출력

	}

	static void quadTree(int i, int j, int n) {

		int num = arr[i][j];	// 사각형의 가장 위&왼의 수와 다른 모든 수가 같은지 판단
		boolean isSame = true;	// 해당 영역 안의 모든 수가 같은지 판단하는 변수
		
		// 틀렸던 이유: 끝에 4개 점만 비교했다. 내부도 모두 조사해야 한다.
		for(int i2 = i; i2 < i+n; i2++)
			for(int j2 = j; j2 < j+n; j2++)
				if(num != arr[i2][j2])  isSame = false;
		
		if(isSame) {	// 같으면 해당 숫자 하나만 추가
			sb.append(arr[i][j]);
		}else {			// 아니면 다시 4개 영역으로 나누어 탐색
			sb.append('(');
			// 상좌
			quadTree(i, j, n/2);
			// 상우
			quadTree(i, j+n/2, n/2);
			// 하좌
			quadTree(i+n/2, j, n/2);
			// 하우
			quadTree(i+n/2, j+n/2, n/2);
			sb.append(')');
		}
	}
}
