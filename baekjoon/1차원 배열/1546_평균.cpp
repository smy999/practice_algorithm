#include <iostream>
#include <stdio.h>
//#include <cstdio>
using namespace std;

int main(void) {
	/* #1546*/
	int N, sub[1000], MAX = 0;
	double avg = 0;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &sub[i]);
		if (MAX < sub[i]) {
			MAX = sub[i];
		}
		avg += sub[i];
	}
	avg = avg / (MAX * N) * 100;
	printf("%0.2f", avg);
}
