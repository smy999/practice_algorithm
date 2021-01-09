#include <stdio.h>
#include <string.h>
using namespace std;

/* #10809*/
int main() {
	char* S = new char[100];
	int alpha[26] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	scanf("%s", S);

	for (int i = 0; i < strlen(S); i++) {
		for (int j = 0; j < 26; j++) {
			if ((S[i] == 97+j) && alpha[j] == -1) {
				alpha[j] = i;
			}
		}
	}
	for (int i = 0; i < 26; i++) {
		printf("%d ", alpha[i]);
	}

}
