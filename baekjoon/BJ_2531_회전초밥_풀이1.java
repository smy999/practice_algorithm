package hwalgo27_서울_13반_서민영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2531_회전초밥 {

	static int N, D, K, C, max;	// 접시의 수, 초밥의 가짓수, 연속해서 먹는 접시의 수, 쿠폰 번호
	static int[] dish;
	static int[] sushi;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		dish = new int[N];
		sushi = new int[D+1];
		
		for(int i = 0; i < N; i++) 
			dish[i] = Integer.parseInt(br.readLine());
		
		// 먹은 초밥 종류
		int cnt = 0;
		
		// 처음 0~K-1까지 먹었을 때
		for(int i = 0; i < K; i++) {
			if(sushi[dish[i]] == 0) cnt++;
			sushi[dish[i]]++;
		}
		
		// 초기 결과
		max = cnt;
		
		for(int i = 1; i < N; i++) {
			
			// 쿠폰 사용할 수 있는지 확인
			if(max <= cnt) {
				max = cnt;
				if(sushi[C] == 0) max++;
			}
			
			// i-1 되돌리기
			sushi[dish[i-1]]--;
			if(sushi[dish[i-1]] == 0) cnt--;
			
			// i+1 검사하기(배열이기 때문에 순환구조를 만들기 위해 %N 사용)
			if(sushi[dish[(i+K-1)%N]] == 0) cnt++;
			sushi[dish[(i+K-1)%N]]++;

		}
		
		System.out.print(max);
	} 
}
