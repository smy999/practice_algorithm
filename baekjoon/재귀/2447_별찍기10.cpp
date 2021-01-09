#include <stdio.h>
using namespace std;

char star[2188][2188];

int blank(int r, int c, int d) {
	for (int t1 = r; t1 < r+d; t1++)
		for (int t2 = c; t2 < c + d; t2++)
			star[t1][t2] = ' ';

	return 0;
}

int stemp(int N, int row, int col) {

	// 이 부분 없으면 메모리 초과
	if (N < 3)
		return 0;

	int div = N / 3;

	// row과 col을 각각 3부분으로 분리하여 3x3 형태로 만든다.
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {

			// 3x3에서 중심이면 ' '을 할당
			if (i == 1 && j == 1)
				blank(row + div, col + div, div);

			// 재귀함수를 사용해 중심을 제외한 나머지들의 중심을 찾아 ' '으로 바꾼다.
			else
				stemp(div, row + div * i, col + div * j);
		}
	}
	return 0;
}

int main() {
	int N;
	scanf("%d", &N);

	// 배열 원소 모두 '*'으로 초기화
	for (int i = 0; i <= N; i++) {
		for (int j = 0; j <= N; j++) {
				star[i][j] = '*';
		}
	}

	// 함수 호출
	stemp(N, 0, 0);

	// 결과 출력
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			printf("%c", star[i][j]);
		}
		printf("\n");
	}
}
