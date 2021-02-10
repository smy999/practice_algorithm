package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열_돌리기1 {
	static int N, M, N2, M2, R, cnt;	// 배열의 크기 NxM, 회전 수
	static int[][] arr;					// 입력 및 회전 배열
	static StringTokenizer st;			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		/* 배열의 크기, 회전 횟수 입력 */
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		/* NxM 배열 생성 */
		arr = new int[N][M];

		/* 배열 입력 */
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		/* R번 회전 */
		for(int r = 0; r < R; r++)
			rotation();	// 한 번 출력할 때마다 한 칸씩 이동

		/* 출력  */
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M-1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(arr[i][M-1]);
		}
	}

	/*
	 * 회전 함수
	 * 밖 테두리에서 안 테두리로 범위를 좁혀가며 회전을 수행
	 */
	private static void rotation() {

		// 회전 볌위 지정 변수들: 초기상태 = 가장 밖 테두리
		int startX = 0;
		int startY = 0;
		int endX = M-1;
		int endY = N-1;

		while(true) {
			// 더 이상 회전할 테두리가 없으면 반환
			if(endX - startX <= 0 || endY - startY <= 0) return;
			
			// 테두리의 가장 위, 가장 왼쪽 원소 값을 임시 변수에 저장
			int temp = arr[startY][startX]; 
			
			// 위쪽 테두리 회전
			for(int j = startX; j < endX; j++)
				arr[startY][j] = arr[startY][j+1];
			
			// 오른쪽 테두리 회전
			for(int i = startY; i < endY; i++)
				arr[i][endX] = arr[i+1][endX];
			
			// 아래쪽 테두리 회전
			for(int j = endX; j > startX; j--)
				arr[endY][j] = arr[endY][j-1];
			
			// 왼쪽 테두리 회전
			for(int i = endY; i > startY; i--)
				arr[i][startX] = arr[i-1][startX];
			
			// 초기에 임시 저장한 변수 하칸 아래에 저장
			arr[startY+1][startX] = temp;
			
			// 안쪽 테두리로 넘어가기 위해 값 증감
			startX++;
			startY++;
			endX--;
			endY--;
			
		}
	}

}


