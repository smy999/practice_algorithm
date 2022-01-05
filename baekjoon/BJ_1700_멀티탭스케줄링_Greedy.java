package Jan_week2;

// 참고 블로그: https://dlee0129.tistory.com/177

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class BJ_1700_멀티탭스케줄링_Greedy {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] eProduct = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			eProduct[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		
		Set<Integer> set = new HashSet<>();	// 멀티탭의 상황(멀미탭에 꽂혀있는 전기제품을 저장한다.)
		for(int i = 0; i < K; i++) {
			// 1. 멀티탭에 이미 꽂혀있는 전기제품인 경우 다음으로 넘어간다.
			if(set.contains(eProduct[i])) continue;
			
			// 2. 멀티탭이 꽉 찼을 때
			if(N <= set.size()) {
				List<Integer> list = new ArrayList<>();		// 남은 전기제품 중에서 사용중인 전기제품(순서대로 들어간다.)
				Set<Integer> remain = new HashSet<>(set);	// 사용하지 않는 전기제품(= 지금 멀티탭에 꽂혀있으나 앞으로 쓰이질 않을 전자제품)
				
				// 위에서 선언한 list와 remain을 구한다.
				for(int j = i; j < K; j++) {
					if(set.contains(eProduct[j]) && !list.contains(eProduct[j])) {
						list.add(eProduct[j]);
						remain.remove(eProduct[j]);
					}
				}
				
				// 2-1. 멀티탭에서 사용중인 N개의 전기제품들이 이후에도 모두 사용된다면 가장 마지막에 쓰이는 전기제품을 제거한다.
				if(list.size() == N) {
					set.remove(list.get(list.size()-1));
				} // 2-2. 멀티탭에서 사용중인 N개의 전기제품 중에서 이후에 사용되지 않는 제품 하나를 제거한다.
				else {
					List<Integer> temp = new ArrayList<>(remain);
					set.remove(temp.get(0));
				}
				
				// 멀티탭이 꽉차있는 경우 무조건 하나의 전기제품을 뽑아야하기 때문에 횟수 증가
				ans++;
			}
			
			// 3. 멀티탭에 여유가 있을 때(멀티탭이 여유가 없을 때까지 set에 추가한다.)
			set.add(eProduct[i]);
		}
		
		System.out.print(ans);
	}
}
