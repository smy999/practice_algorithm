#include <stdio.h>
#include <string.h>
#include <iostream>
#include <string>	// getline() 헤더
using namespace std;

/* #2941*/
int main() {
	int i = 0, count = 0;;
	char* croatian = new char[100];
	scanf("%s", croatian);

	for (; i < strlen(croatian);) {
		if (croatian[i] == 'c' && croatian[i + 1] == '=') {
			count++;
			i += 2;
		}
		else if (croatian[i] == 'c' && croatian[i + 1] == '-') {
			count++;
			i += 2;
		}
		else if (croatian[i] == 'd' && croatian[i + 1] == 'z' && croatian[i + 2] == '=') {
			count++;
			i += 3;
		}
		else if (croatian[i] == 'd' && croatian[i + 1] == '-') {
			count++;
			i += 2;
		}
		else if (croatian[i] == 'l' && croatian[i + 1] == 'j') {
			count++;
			i += 2;
		}
		else if (croatian[i] == 'n' && croatian[i + 1] == 'j') {
			count++;
			i += 2;
		}
		else if (croatian[i] == 's' && croatian[i + 1] == '=') {
			count++;
			i += 2;
		}
		else if (croatian[i] == 'z' && croatian[i + 1] == '=') {
			count++;
			i += 2;
		}
		else {
			count++;
			i++;
		}
	}
	printf("%d", count);
}
