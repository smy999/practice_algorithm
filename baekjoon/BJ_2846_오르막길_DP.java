package 과목평가8대비문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2846_오르막길_DP {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] height = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		// 거리가 1일 때는 높이를 출력한다.
		if(N == 1) {
			System.out.print(height[0]);
			br.close();
			return;
		}
		
		int max = 0;	// 최대값(오르막길이 없이 평지, 내리막길 이러도 0이 나와야 하기 때문에 0으로 설정)
		int sum = 0;	// 오르막길의 합

		for(int i = 0; i < N-1; i++) {
			if(height[i] < height[i+1]) sum += height[i+1]-height[i];
			else sum = 0;
			
			// 최대 오르막길 높이 갱신
			max = Math.max(max, sum);
		}
		
		System.out.print(max);
		br.close();
	}
}

/*
 * Test Case

5
1 4 2 3 6

8
12 20 1 3 4 4 11 1

*/
