#include <iostream>
#include <stdio.h>
//#include <cstdio>
using namespace std;

int main(void) {
	int num, mod[42] = { 0 }, count = 0;
	for (int i = 0; i < 10; i++) {
		scanf("%d", &num);
		mod[num%42] = 1;
	}
	for (int i = 0; i < 42; i++) {
		count += mod[i];
	}
	printf("%d", count);
} 
