#include <stdio.h>
#include <cstring>
#include <cstdio>
using namespace std;


const int MAX = 1000000;
int N, arr[MAX];

// swap
void swap(int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
}

void heap(int p, int n) {

	while (p < n) {

		int c1 = p * 2 + 1;		// ledt child
		int c2 = p * 2 + 2;		// right child

		if (c1 < n || c2 < n) {
			int tmp = p;

			if (c1 < n) {
				if (arr[c1] > arr[tmp]) tmp = c1;
			}

			if (c2 < n) {
				if (arr[c2] > arr[tmp]) tmp = c2;
			}

			if (tmp == p) break;

			swap(p, tmp);
			p = tmp;
		}
		else break;
	}
	return;
}


void heapify() {
	for (int i = (N - 1) / 2; i >= 0; i--) {
		heap(i, N);
	}

	return;
}

int main() {

	// initialize all
	memset(arr, 0, sizeof(arr));

	// input size
	scanf("%d", &N);

	// input
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}

	// create heap
	heapify();

	// heap sort
	for (int i = N - 1; i > 0; i--) {
		// 루트(최대값)와 마지막 노드를 바꾼다.
		swap(0, i);
		// 마지막 노드를 제외하고 힙 정렬을 진행한다.
		heap(0, i);
	}

	// output
	for (int i = 0; i < N; i++) {
		printf("%d\n", arr[i]);
	}

	return 0;
}
