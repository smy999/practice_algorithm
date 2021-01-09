#include <iostream>
#include <stdio.h>

using namespace std;

int main() {
	int N, digits, temp, M, sum=0;
	scanf("%d", &N);

	temp = N;
	for (int i = 1;; i++) {
		temp /= 10;
		if (temp <= 0) {
			digits = i;
			break;
		}
	}

	M = N-(digits*9);

	for (; M < N; M++) {
		temp = M;
        sum = M;
		while (temp != 0) {
			sum += (temp % 10);
			temp /= 10;
		}
		if (sum == N)
			break;
	}

	if (M == N)
		printf("0");
	else
		printf("%d", M);
}
