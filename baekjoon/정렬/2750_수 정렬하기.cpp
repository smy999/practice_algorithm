#include <iostream>
#include <stdio.h>
#include <vector>
using namespace std;

int main() {
	int N, temp;
	vector<int> asc;
	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d", &temp);
		asc.push_back(temp);
	}

	for (int i = N; i > 0; i--) {
		for (int j = 0; j < i-1; j++) {
			if (asc[j] > asc[j+1]) {
				temp = asc[j];
				asc[j] = asc[j+1];
				asc[j+1] = temp;
			}
		}
	}
	
	for (int i = 0; i < N; i++) {
		printf("%d\n", asc[i]);
	}

	return 0;
}
