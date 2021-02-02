import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
   // ts횟수, 입력ts, x좌표, y좌표, 현재방향(0: 상, 1: 우, 2: 좌), 배열크기
	static int T, tc, startX, startY, current, MAX = 100;
	static int[][] radder = new int[MAX][MAX];	// 입력 배열

	static int[] dx = { 0, 1, -1 };	// 상, 우, 좌
	static int[] dy = { -1, 0, 0 };
    
    public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
        T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            tc = sc.nextInt();

			for (int i = 0; i < MAX; i++)		// 입력
				for (int j = 0; j < MAX; j++)
					radder[i][j] = sc.nextInt();

			for (int j = 0; j < MAX; j++)		// 도착점 찾기 = 순회 시작 지점
				if (radder[99][j] == 2)
					startX = j;					// j = x축
			startY = 99;						// i = y축

			current = 0;						// 현재 방향의 초기 값은 상
			while (true) {
				for (int d = 0; d < 3; d++) {
					if (d != current) {			// 현재 방향과 순회 방향이 다를 경우

						int nx = startX + dx[d];
						int ny = startY + dy[d];

						if (nx >= 0 && nx < MAX && ny >= 0 && ny < MAX && (radder[ny][nx] == 1)) {
							current = d;		// d방향에 1을 가지는 요소가 있다면 현재 방향을 d값으로 변경
							break;
						}
					}
				}
				startX += dx[current]; 			// 이동
				startY += dy[current];
				radder[startY][startX] = 0;		// 이동한 위치의 값 0으로 변경 = 중복되어 지나가지 않도록
				if (startY == 0) break;			// 출발점에 도착하면 순회 종료

			}
			System.out.println("#" + tc + " " + startX);	// 결과 출력
		}
		sc.close();
	}
}
