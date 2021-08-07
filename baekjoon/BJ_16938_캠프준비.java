package Aug_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16938_캠프준비 {

	static int N, L, R, X, result;
	static int[] level;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		level = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			level[i] = Integer.parseInt(st.nextToken());

		dfs(0, 0, 1000001, -1, 0);
		
		System.out.print(result);
		br.close();
	}
	
	public static void dfs(int cnt, int idx, int min, int max, int sum) {
		if(cnt >= 2) {
			if(L <= sum && sum <= R && max-min >= X) result++;
		}
		
		if(idx == N) return;
		
		for(int i = idx; i < N; i++)
			dfs(cnt+1, i+1, Math.min(min, level[i]), Math.max(max, level[i]), sum+level[i]);
	}
}
