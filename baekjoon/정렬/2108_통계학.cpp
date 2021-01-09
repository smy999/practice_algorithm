#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cstdio>
#include <math.h>
using namespace std;


/* #2108*/
/**/

vector<int> arr;					// input vector
vector<int> count_arr(8001, 0);		// counting vector
vector<int> second_small;			// second smallest vector

int main() {
	
	int N;							// number of input
	scanf("%d", &N);
		
	int min = 4000, max = -4000;		// min, max variable
	int sum = 0;					// sum variable
	int cnt = 0;					// maxium count variable
	int mid;						// median variable
	
	for (int i = 0; i < N; i++) {
		int temp;
		scanf("%d", &temp);
		arr.push_back(temp);

		// sum input value
		sum += arr[i];

		// count input value
		count_arr[arr[i] + 4000]++;

		// min & max value
		if (arr[i] <= min)
			min = arr[i];
		if (arr[i] >= max)
			max = arr[i];
	}

	// sort & get median
	sort(arr.begin(), arr.end());
	mid = arr[N / 2];

	// get maxium count
	for (int i = 0; i < 8001; i++)
		if (count_arr[i] >= cnt)
			cnt = count_arr[i];
	
	// maxium vector
	for (int i = 0; i < 8001; i++)
		if (count_arr[i] == cnt)
			second_small.push_back(i);
	
	if (second_small.size() == 1)				// when the maxium values is one
		cnt = second_small[0] - 4000;
	else										// when the maxium values is multiple
		cnt = second_small[1] - 4000;


	// output
	printf("%d\n", (int)round(sum / (double)N));
	printf("%d\n", mid);
	printf("%d\n", cnt);
	printf("%d\n", max - min);

	return 0;
}
