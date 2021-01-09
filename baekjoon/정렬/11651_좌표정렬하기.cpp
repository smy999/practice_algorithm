#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(pair<int, int>& a, pair <int, int>& b) {
	if (a.second < b.second)
		return true;
	else if (a.second == b.second) {
		if (a.first < b.first)
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
