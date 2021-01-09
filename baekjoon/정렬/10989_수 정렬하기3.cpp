#include <stdio.h>

int main() {

	int N, max = 0;
	int count[10001] = { 0 };

	scanf("%d", &N);

	int temp;
	for (int i = 0; i < N; i++) {
		scanf("%d", &temp);
		count[temp]++;
	}

	for (int i = 1; i <= 10000; i++) 
		for (int j = 0; j < count[i]; j++)
			printf("%d\n", i);

	return 0;
}
