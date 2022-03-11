package Mar_week1_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2281_데스노트_DP {

	static int N, M;
	static int[] name;
	static int[][] DP = new int[1002][1002];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		name = new int[N];
		for(int i = 0; i < N; i++) name[i] = Integer.parseInt(br.readLine());
		
		for(int[] dp : DP) Arrays.fill(dp, -1);	// DP 초기
		
		System.out.print(check(1, name[0]+1));	// name[0]에서 1은 공백 포함
	}
	
	public static int check(int idx, int cnt) {
		if(idx == N) return 0;		// 모든 이름 다 구했을 때
		if(DP[idx][cnt] != -1) return DP[idx][cnt];	// 이미 구했을 때
		
		// 다음줄
		int left = M - cnt + 1;		// 1은 공백 제거
		DP[idx][cnt] = check(idx+1, name[idx]+1) + (left * left);	// 새로운 줄: 해당 이름의 길이 + 공백
		
		// 현재줄
		if(cnt + name[idx] <= M)
			DP[idx][cnt] = Math.min(check(idx+1, cnt + name[idx]+1), DP[idx][cnt]);	// 이어지는 줄: 지금까지 이름의 길이(cnt) + 이름의 길이 + 공백
		
		return DP[idx][cnt];
	}
}
