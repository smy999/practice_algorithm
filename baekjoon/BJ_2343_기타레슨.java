package Sep_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2343_기타레슨 {
	
	static int N, M;
	static int[] lesson;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 레슨 수
		M = Integer.parseInt(st.nextToken());	// 블루레이 수

		lesson = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int max = 0;					// 레슨 크기의 최대값
		int total = 0;
		
		for(int i = 0; i < N; i++) {	
			int num = Integer.parseInt(st.nextToken());
			if(max < num) max = num;	// 레슨 크기 최대값 갱신
			total += num;				// 총 레슨의 크기 합
			lesson[i] = num;			// 레슨 순서대로 저장
		}
		
		System.out.print(binarySearch(max, total));			// 결과 출력
	}
	
	public static int binarySearch(int left, int right) {
		int nl = left;
		int nr = right;
		
		while(nl <= nr) {
			int mid = (nl+nr)/2;	// 블루레이 크기 후보
			
			int sum = 0;
			int cnt = 1;
			
			for(int i = 0; i < N; i++) {
				sum += lesson[i];
				
				// 레슨을 더한 값이 하나의 블루레이 크기 후보보다 크다면 
				if(sum > mid) {
					sum = lesson[i];	// 다음 블루레이에 들어갈 첫번째 레슨의 크기를 sum에 저장한다.
					cnt++;				// 더이상 더하지 않고 블루레이 수를 늘린다.
				}
			}
			
			// 필요한 블루레이의 수가 M보다 크다면 nl=mid+1로 변경하고
			// 레슨을 분리한 그룹의 수가 M보다 작거나 같다면 nr=mid-1로 변경한다.
			if(cnt > M) nl = mid + 1;
			else nr = mid - 1;
		}
		
		return nl;
	}
}

