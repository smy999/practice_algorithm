#include <stdio.h>
using namespace std;

void AP(int N) {
	int count = 0;
	for (int i = 1; i <= N; i++) {
		if (i < 100) {
			count++;
		}
		else if (i < 1000) {
			if ((i / 100) - ((i % 100) / 10) == ((i % 100) / 10) - ((i % 100) % 10))
				count++;
		}
	}
	printf("%d", count);
}

int main() {
	int N;
	scanf("%d", &N);
	AP(N);
}
