#include <iostream>
#include <stdio.h>
using namespace std;

int main(void) {
	/* #10818*/
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, temp, MAX = 1000000, MIN = -1000000;
    cin >> N;
	int* arr = new int[N];
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
        if (MIN < arr[i]) {
			MIN = arr[i];
		}
		if (MAX > arr[i]) {
			MAX = arr[i];
		}
	}
	cout << MAX << " " << MIN;
	return 0;
}
