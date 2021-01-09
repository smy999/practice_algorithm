#include <iostream>
#include <stdio.h>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string N1;
	int N2[10];

	// input
	cin >> N1;
	int size = N1.size();

	// char to int
	for (int i = 0; i < size; i++)
		N2[i] = N1[i] - '0';

	// sort
	for (int i = 0; 0 < size-i; i++) {
		for (int j = 0; j < size-i-1; j++) {
			if (N2[j] < N2[j + 1]) {
				int temp = N2[j];
				N2[j] = N2[j + 1];
				N2[j + 1] = temp;
			}
		}
	}

	// output
	for (int i = 0; i < size; i++)
		cout << N2[i];

	return 0;
}
