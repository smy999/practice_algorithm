#include <iostream>
using namespace std;

int main(void) {
	/* #2562*/
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int arr[9], MAX = 0, num, order;
	for (int i = 0; i < 9; i++) {
		cin >> num;
		arr[i] = num;
		if (MAX < num) {
			MAX = num;
			order = i + 1;
		}
	}
	cout << MAX << "\n" << order;
} 
