#include <iostream>
#include <stdio.h>

using namespace std;

int main() {
	int N;
	scanf("%d", &N);

	int x[50] = { 0 };
	int y[50] = { 0 };
	int rank;

	for (int i = 0; i < N; i++)
		scanf("%d %d", &x[i], &y[i]);

	for (int i = 0; i < N; i++) {
		rank = 1;
		for (int j = 0; j < N; j++) {
			if ((x[i] < x[j]) && (y[i] < y[j]))
				rank++;
		}
		printf("%d ", rank);
	}

	return 0;
}
