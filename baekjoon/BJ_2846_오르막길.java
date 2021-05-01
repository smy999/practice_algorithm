package 과목평가8대비문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2846_오르막길 {

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
		int start = height[0];	// 오르막길 시작점
		int end = height[1];	// 오르막길 끝점
		
		// 주의: i, i+1로 비교하면 오버플로우가 발생할 수 있다.
		for(int i = 1; i < N; i++) {
			if(height[i-1] < height[i]) {	// 오르막길일 때 끝점을 갱신한다.
				end = height[i];
			}
			else {	// 오르막길이 아닐 때
				start = height[i];	// 시작점을 현재 높이로 바꾸고
				end = 0;			// 끝점을 0으로 설정한다.
			}
			
			// 최대 오르막길 높이 갱신
			max = Math.max(max, end-start);
			// System.out.println("start: " + start + ", end: " + end);	// 확인 출력
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
