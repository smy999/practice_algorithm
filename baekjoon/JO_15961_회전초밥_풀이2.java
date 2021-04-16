package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_15961_회전초밥_sol {

	static int N, d, k, c, max;	// 접시의 수, 초밥의 가짓수, 연속해서 먹는 접시의 수, 쿠폰 번호
	static int[] src;	// 초밥 바열
	static int[] select = new int[3001];	// 1부터 시작
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		
		for(int i = 0; i < N; i++) 
			src[i] = Integer.parseInt(br.readLine());
		
		// 쿠폰 처리
		select[c] = 1;
		// c를 선택했으니 종류 변수도 1 증가
		int kind = 1;
		
		// 처음 k개를 먼저 처리
		for(int i = 0; i < k; i++) {
			if(select[src[i]] == 0) kind++;	// 처음 나타난 초밥 종류
			select[src[i]]++;	// 현재까지 해당 종류가 몇개 나왔는지(중복 개수)
		}
		
		// max 값 갱신
		max = Math.max(max, kind);
		
		for(int i = k; i < N+k-1; i++) {
			
			// 제일 앞 접시 정보 제거
			int dish = src[i-k];
			select[dish]--;
			if(select[dish] == 0) kind--;
			
			// 다음 접시 추가
			if(i < N) dish = src[i];
			else dish = src[i-N];
			
			if(select[dish] == 0) kind++;	// 처음 나타난 초밥 종류
			select[dish]++;	// 현재까지 해당 종류가 몇개 나왔는지(중복 개수)
			
			// max 갱신
			max = Math.max(max, kind);
			
			if(max == k+1) break;
		}
		
		System.out.print(max);
	} 
}
