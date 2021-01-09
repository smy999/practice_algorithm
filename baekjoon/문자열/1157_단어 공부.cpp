#include <stdio.h>
#include <string.h>
using namespace std;

/* #1157*/
int main() {
	char* input = new char[1000000];
	int count[26] = { 0 }, max = 0, flag, result, len;

	scanf("%s", input);
	len = strlen(input);
    
	for (int i = 0; i < len; i++) {
		for (int j = 0; j < 26; j++) {
			if ((input[i] == 65 + j) || (input[i] == 97 + j)) {
				count[j]++;
			}
		}
	}

	for (int i = 0; i < 26; i++) {
		if (count[i] == max) {
			flag = -1;
		}
		else if (count[i] > max) {
			max = count[i];
			flag = 0;
			result = i;
		}
		
	}

	if (flag == -1) {
		printf("?\n");
	}
	else {
		printf("%c\n", 65 + result);
	}
}
