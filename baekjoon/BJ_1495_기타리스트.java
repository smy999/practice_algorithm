package Feb_week4;

// 참고 풀이: https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1495-%EA%B8%B0%ED%83%80%EB%A6%AC%EC%8A%A4%ED%8A%B8-JAVA%EC%9E%90%EB%B0%94

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1495_기타리스트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] DP = new int[M+1];
		Arrays.fill(DP, -1);
		DP[S] = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int V = Integer.parseInt(st.nextToken());
			ArrayList<Integer> vList = new ArrayList<>();
			
			for(int j = 0; j <= M; j++) {
				// i-1 번째에 있는 수에서 i번째로 만들어 질 수 있는 수를 찾는다.
				if(DP[j] == i-1) {
					if(j - V >= 0) vList.add(j - V);
					if(j + V <= M) vList.add(j + V);
				}
			}
			
			// i 번째에 만들어질 수 있는 숫자를 저장
			for(int v : vList) DP[v] = i;
		}
		
		// N 번째 수로 만들어질 수 있는 수 중에서 가장 큰 수를 찾는다.
		for(int i = M; i >= 0; i--) {
			if(DP[i] == N) {
				System.out.print(i);
				return;
			}
		}
		
		System.out.print(-1);
	}
}
