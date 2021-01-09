#include <iostream>
#include <stdio.h>

using namespace std;

string input[50] = { "" };
string black[8] = { "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB" };
string white[8] = { "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW" };

int func_black(int a, int b) {
	int cnt_B = 0;

	for (int i = 0; i <= 7; i++) {
		for (int j = 0; j <= 7; j++) {
			if (input[a + i][b + j] != black[i][j])
				cnt_B++;
		}
	}

	return cnt_B;
}

int func_white(int a, int b) {
	int cnt_W = 0;

	for (int i = 0; i <= 7; i++) {
		for (int j = 0; j <= 7; j++) {
			if (input[a + i][b + j] != white[i][j])
				cnt_W++;
		} 
	}

	return cnt_W;
}

int main() {
	int M, N;
	cin >> M >> N;

	int min=64, temp_B, temp_W;

	for (int i = 0; i < M; i++)
		cin >> input[i];

	for (int i = 0; i <= M-8; i++) {
		for (int j = 0; j <= N-8; j++) {
			temp_B = func_black(i, j);
			temp_W = func_white(i, j);

			if (temp_B < min)
				min = temp_B;
			if (temp_W < min)
				min = temp_W;
		}
	}

	cout << min;

	return 0;
}
