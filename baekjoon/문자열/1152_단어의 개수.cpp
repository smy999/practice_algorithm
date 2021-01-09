#include <stdio.h>
#include <string.h>
#include <iostream>
#include <string>	// getline() 헤더
using namespace std;

/* #1152*/
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	std::cout.tie(NULL);

	int count = 1;
	char input[1000000];
	cin.getline(input, 1000000);
	
	int len = strlen(input);
	for (int i = 0; i < len; i++) {	
		if (input[i] == ' ') {
			count++;
		}
	}

	if (input[0] == ' ')
		count--;
	if (input[len - 1] == ' ')
		count--;

	cout << count;
}
