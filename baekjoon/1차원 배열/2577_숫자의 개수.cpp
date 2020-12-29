#include <iostream>
#include <stdio.h>
using namespace std;

int main(void) {
	/* #2577*/
	int A, B, C, count[10] = { 0,0,0,0,0,0,0,0,0,0 }, digit = 0;
	scanf("%d", &A);
	scanf("%d", &B);
	scanf("%d", &C);
	int num = A * B * C;
	int temp = num;
	while (num!=0) {
		num = num / 10;
		digit++;
	}
	for (int i = 0; i < digit; i++) {
		if (temp % 10 == 0) {
			count[0]++;
		}
		if (temp % 10 == 1) {
			count[1]++;
		}
		if (temp % 10 == 2) {
			count[2]++;
		}
		if (temp % 10 == 3) {
			count[3]++;
		}
		if (temp % 10 == 4) {
			count[4]++;
		}
		if (temp % 10 == 5) {
			count[5]++;
		}
		if (temp % 10 == 6) {
			count[6]++;
		}
		if (temp % 10 == 7) {
			count[7]++;
		}
		if (temp % 10 == 8) {
			count[8]++;
		}
		if (temp % 10 == 9) {
			count[9]++;
		}
		temp = temp / 10;
	}
	for (int i = 0; i < 10; i++) {
		printf("%d\n", count[i]);
	}
} 
