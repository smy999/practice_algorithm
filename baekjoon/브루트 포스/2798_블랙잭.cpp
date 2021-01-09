#include <iostream>
#include <stdio.h>

using namespace std;

int main() {

	int N, M, temp, sum=0, input;
	scanf("%d", &N);
	scanf("%d", &M);

	int* card = new int[N];

	for (int i = 0; i < N; i++) {
		scanf("%d", &input);
		card[i] = input;
	}

	for (int i = N - 1; i >= 0; i--) {
		for (int j = i - 1; j >= 0; j--) {
			for (int k = j - 1; k >= 0; k--) {
				temp = card[i] + card[j] + card[k];
				
				if (sum < temp && temp <= M)
					sum = temp;
			}
		}
	}

	printf("%d", sum);
}
