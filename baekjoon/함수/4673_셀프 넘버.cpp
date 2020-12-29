#include <iostream>
#include <stdio.h>
using namespace std;

int self_num[10000] = { 0 };

int d() {
	for (int i = 1; i <= 10000; i++) {
		int temp = i;
		if (i < 10000) {
			temp += (i / 1000) + ((i % 1000) / 100) + (((i % 1000) % 100) / 10) + (((i % 1000) % 100) % 10);
		}
		else if (i < 1000) {
			temp += (i / 100) + ((i % 100) / 10) + ((i % 100) % 10);
		}
		else if (i < 100) {
			temp += (i / 10) + (i % 10);
		}
		else if (i < 10) {
			temp += i;
		}

		self_num[temp] = 1;
	}
	return 0;
}

/* #4673*/
int main() {
	d();
	for (int i = 1; i <= 10000; i++) {
		if (self_num[i] == 0)
			printf("%d\n", i);
	}
	return 0;
}
