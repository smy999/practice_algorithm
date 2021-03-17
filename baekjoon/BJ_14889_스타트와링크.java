package hwalgo16_서울_13반_서민영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {
	
	static int N, min=Integer.MAX_VALUE;	// 입력 크기, 경험지차 최소값(결과)
	static int[][] stats;		// 경험치 배열
	static int[] A, B;			// 두 개의 팀
	static boolean[] select;	// 팀 가르기용 배열
	
	public static void main(String[] args) throws Exception {
		// line 16~26: 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		stats = new int[N][N];
		select = new boolean[N];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 조합으로 팀 가르고 경험치 최소값 구하기
		comb(0, 0);
		
		// 결과 출력
		System.out.print(min);
	}
	
	static void comb(int sIdx, int idx) {
		// 기저1: N/2 크기를 갖는 팀 2개가 만들어 졌을 때
		if(sIdx == N/2) {
			// 팀가르기
			A = new int[N/2];
			B = new int[N/2];
			int aIdx = 0, bIdx = 0;
			for(int i = 0; i < N; i++) {
				if(select[i]) A[aIdx++] = i;
				else B[bIdx++] = i;
			}
			// getStats으로 팀별 경험치 합 구하여 팀 경험지 차의 최소값 구하기
			min = Math.min(min, Math.abs(getStats(A)-getStats(B)));
			return;
		}
		
		// 기저2: 더이상 선택할 사람이 없을 때
		if(idx == N) return;
		
		// 주의: select 안의 인자가 sIdx가 아닌 idx이다.
		select[idx] = true;	// 선택
		comb(sIdx+1, idx+1);
		select[idx] = false;// 비선택
		comb(sIdx, idx+1);
	}
	
	static int getStats(int[] arr) {
		int sum = 0;
		for(int i = 0; i < N/2; i++) 
			for(int j = i+1; j < N/2; j++) 
				sum += stats[arr[i]][arr[j]] + stats[arr[j]][arr[i]];
		return sum;
	}
}
