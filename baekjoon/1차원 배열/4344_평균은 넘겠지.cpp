#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

int main(void) {
	/* #4344*/
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int C, N, sum, count;
	double avg, ratio;

	cin >> C;
	int* score = new int[C];

	for (int i = 0; i < C; i++) {
		N = 0;	sum = 0;	count = 0;
		
		cin >> N;
		for (int j = 0; j < N; j++) {
			cin >> score[j];
			sum += score[j];
		}
		
		avg = (double)sum / N;
		
		for (int j = 0; j < N; j++) {
			if (score[j] > avg) {
				count++;
			}
		}
			
		ratio = ((double)count / N) * 100;
		cout.precision(3);
		cout << fixed << ratio << "%" << "\n";
	}
}
