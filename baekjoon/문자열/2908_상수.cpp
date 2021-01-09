#include <stdio.h>
#include <string.h>
#include <iostream>
#include <string>	// getline() 헤더
using namespace std;

/* #2908*/
int main() {
	int n1, n2, back1[3], back2[3], flag;
	scanf("%d %d", &n1, &n2);

	for (int i = 0; i < 3; i++) {
		back1[i] = n1 % 10;
		back2[i] = n2 % 10;
		
		n1 /= 10;
		n2 /= 10;
	}

	for (int i = 0; i < 3; i++) {
		if (back1[i] > back2[i]) {
			flag = 1;
			break;
		}
		else if (back1[i] < back2[i]) {
			flag = 2;
			break;
		}
		else {
			continue;
		}
	}

	if (flag == 1) {
		printf("%d%d%d", back1[0], back1[1], back1[2]);
	}
	else {
		printf("%d%d%d", back2[0], back2[1], back2[2]);
	}
}
