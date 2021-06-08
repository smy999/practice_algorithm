package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분탐색

public class BJ_2805_나무자르기 {

	static int N, M;
	static int[] trees;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		trees = new int[N];
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		// 오류1: 나무 높이가 아닌 인덱스로 이분탐색을 진행했다.
		System.out.print(binarySearch());
	}
	
	public static int binarySearch() {
		int mid = 0;
		int left = 1;
		int right = trees[N-1];
		
		// 오류3: int가 아닌 long이다.
		// 높이가 1,000,000,000인 나무 1,000,000개의 합은 int로 표현할 수 없다.
		long midTreeH = 0;
		
		while(right >= left) {
			mid = (left+right)/2;
			
			midTreeH = 0;
			for(int i = 0; i < N; i++) {
				if(trees[i] < mid) continue;
				midTreeH += (trees[i] - mid);
			}
			
			// 오류2: 잘라서 구한 나무의 합이 M이 될 수 없는 경우도 있다.
//			if(cuttingTreeLen == M) {
//				H = mid;
//				break;
//			}
			
			if (midTreeH >= M) left = mid + 1;
			else right = mid - 1;

		}
	
		// 마지막 mid에서 하나 작은 값을 선택해야 한다.
		return right;
	}
	
}
