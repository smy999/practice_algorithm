#include <vector>
#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <cstring>
#include <cstdio>
#include <math.h>
using namespace std;



/* #11650*/
// 버블정렬 시간초과
/**/
bool compare(pair<int, int> &a, pair <int, int> &b) {
	if (a.first < b.first)
		return true;
	else if (a.first == b.first) {
		if (a.second < b.second)
			return true;
		else
			return false;
	}
	else
		return false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	vector <pair<int, int>> location;

	cin >> N;
	location.resize(N);

	for (int i = 0; i < N; i++)
		cin >> location[i].first >> location[i].second;

	sort(location.begin(), location.end(), compare);


	for (int i = 0; i < N; i++)
		cout << location[i].first << " " << location[i].second << "\n";

	return 0;
}
