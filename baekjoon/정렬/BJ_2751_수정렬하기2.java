package 정렬;

// https://hmkim829.tistory.com/9

import java.io.*;

public class BJ_2751_수정렬하기2 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		/* 1. 데이터 입력 */
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		/* 2. 최대힙 생성 */
		for(int i = N/2-1; i >= 0; i--)
			minHeap(N, i);

		/* 3. 정렬 */
		for(int i = N-1; i > 0; i--) {
			swap(0, i);		// 마지막에 최대값 고정
			minHeap(i, 0);	// 사이즈 하나 줄여(고정된 마지막 원소 제외) root부터 다시 정렬
		}
		
		/* 4. 출력 */
		for(int i = 0; i < N; i++)
			bw.write(String.valueOf(arr[i]) + "\n");
		
		bw.flush();
		bw.close();
	}

	/* swap: 값 교환 */
	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/* heap sort: 힙정렬 */
	static void minHeap(int size, int i) {
		int p = i;		// 부모 index
		int l = p*2+1;	// 왼쪽 자식 index
		int r = p*2+2;	// 오른쪽 자식 index

		// index 검사 및 비교
		if(l < size && arr[p] < arr[l]) p = l;
		if(r < size && arr[p] < arr[r]) p = r;
		
		// 부모가 자식보다 작으면 값 교환 후 서브 트리 탐색
		if(p != i) {
			swap(p, i);			// 부모 <-> 자식 값 교환
			minHeap(size, p);	// 이어서 서브 트리 탐색 및 정렬
		}
	}
}
