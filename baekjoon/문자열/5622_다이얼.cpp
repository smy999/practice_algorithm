#include <stdio.h>
#include <string.h>
#include <iostream>
#include <string>	// getline() 헤더
using namespace std;

/* #5622*/
int main() {
	int seconds = 0;
	char input[15];

	scanf("%s", input);

	for (int i = 0; i < strlen(input); i++) {
		if (input[i] == 'A' || input[i] == 'B' || input[i] == 'C') {
			seconds += 3;
		}
		else if (input[i] == 'D' || input[i] == 'E' || input[i] == 'F') {
			seconds += 4;
		}
		else if (input[i] == 'G' || input[i] == 'H' || input[i] == 'I') {
			seconds += 5;
		}
		else if (input[i] == 'J' || input[i] == 'K' || input[i] == 'L') {
			seconds += 6;
		}
		else if (input[i] == 'M' || input[i] == 'N' || input[i] == 'O') {
			seconds += 7;
		}
		else if (input[i] == 'P' || input[i] == 'Q' || input[i] == 'R' || input[i] == 'S') {
			seconds += 8;
		}
		else if (input[i] == 'T' || input[i] == 'U' || input[i] == 'V') {
			seconds += 9;
		}
		else {
			seconds += 10;
		}
	}
	printf("%d", seconds);
}
