package hwalgo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935_배열_돌리기3 {

	static int N, M, R;			// 배열의 크기
	static int[][] input;		// 입력 및 반환 배열
	static int[][] transpose;	// 90도 회전 임시 저장 배열
	static int[][] quadrant;	// 사분면 회전 임시 저장 배열
	static StringTokenizer st;	// 입력 시 공백 제거 저장

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/* line 21~25: 배열 크기 및 연산 수 입력 */
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		/* line 28~34: NxM 배열 생성 및 원소 값 입력 */
		input = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/* 연산 번호에 따라 처리 */
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1: reverseUD(); break;
			case 2: reverseLR(); break;
			case 3: rotationR(); break;
			case 4: rotationL(); break;
			case 5: quadrantR(); break;
			case 6: quadrantL(); break;
			}
		}

		/* 출력 */
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M-1; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println(input[i][M-1]);
		}
	}

	/* 상하 반전 */
	static void reverseUD() {
		int center = N/2;

		for(int i = 0; i < center; i++) {
			for(int j = 0; j < M; j++) {
				int temp = input[i][j];
				input[i][j] = input[N-1-i][j];
				input[N-1-i][j] = temp;
			}
		}
	}

	/* 좌우 반전 */
	static void reverseLR() {
		int center = M/2;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < center; j++) {
				int temp = input[i][j];
				input[i][j] = input[i][M-1-j];
				input[i][M-1-j] = temp;
			}
		}
	}

	/* 오른쪽으로 90도 회전*/
	static void rotationR(){
		transpose = new int[M][N];

		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				transpose[i][j] = input[N-1-j][i];

		int temp = N; N = M; M = temp;

		input = new int[N][M];
		input = transpose;
	}

	/* 왼쪽으로 90도 회전 */
	static void rotationL(){
		transpose = new int[M][N];

		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				transpose[i][j] = input[j][M-1-i];

		int temp = N; N = M; M = temp;

		input = new int[N][M];
		input = transpose;
	}

	/* 오른쪽으로 사분면 회전*/
	static void quadrantR(){
		quadrant = new int[N/2][M/2];

		for(int i = 0; i < N/2; i++)	// 1 사분면 임시 저장
			for(int j = 0; j < M/2; j++)
				quadrant[i][j] = input[i][j];

		for(int i = 0; i < N/2; i++) 	// 4 사분면 -> 1 사분면
			for(int j = 0; j < M/2; j++) 
				input[i][j] = input[N/2+i][j];

		for(int i = N/2; i < N; i++)	// 3 사분면 -> 4 사분면
			for(int j = 0; j < M/2; j++)
				input[i][j] = input[i][M/2+j];

		for(int i = 0; i < N/2; i++)	// 2 사분면 -> 3 사분면
			for(int j = M/2; j < M; j++)
				input[N/2+i][j] = input[i][j];

		for(int i = 0; i < N/2; i++)	// 임시 저장 -> 2사분면
			for(int j = 0; j < M/2; j++)
				input[i][M/2+j] = quadrant[i][j];
	}

	/* 왼쪽으로 사분면 회전 */
	static void quadrantL(){
		quadrant = new int[N/2][M/2];

		for(int i = 0; i < N/2; i++)	// 1 사분면 임시 저장
			for(int j = 0; j < M/2; j++)
				quadrant[i][j] = input[i][j];

		for(int i = 0; i < N/2; i++) 	// 2 사분면 -> 1 사분면
			for(int j = 0; j < M/2; j++) 
				input[i][j] = input[i][M/2+j];

		for(int i = 0; i < N/2; i++)	// 3 사분면 -> 2 사분면
			for(int j = M/2; j < M; j++)
				input[i][j] = input[N/2+i][j];

		for(int i = N/2; i < N; i++)	// 4 사분면 -> 3 사분면
			for(int j = 0; j < M/2; j++)
				input[i][j+M/2] = input[i][j];

		for(int i = 0; i < N/2; i++)	// 임시 저장 -> 4사분면
			for(int j = 0; j < M/2; j++)
				input[N/2+i][j] = quadrant[i][j];
	}

}
