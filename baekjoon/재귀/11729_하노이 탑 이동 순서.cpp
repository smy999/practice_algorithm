#include <stdio.h>
#include <math.h>
using namespace std;


/* #11729*/
/**/

int hanoi(int n, int from, int by, int to) {
	if (n == 0)
		return 0;
	else {
		hanoi(n - 1, from, to, by);
		printf("%d %d\n", from, to);
		hanoi(n - 1, by, from, to);		// 마지막 원판이 3번째 장대에 위치
	}
	return 0;
}

int main() {
	int N, count=1;
	scanf("%d", &N);

	
	// pow는 실수를 리턴하기 때문에 형변환
	printf("%d\n", (int)pow(2, N) - 1);

	hanoi(N, 1, 2, 3);

	return 0;
}
