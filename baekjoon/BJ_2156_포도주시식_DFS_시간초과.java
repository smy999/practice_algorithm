package July_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2156_포도주시식_DFS_시간초과 {

	static int N, totalWine;
	static int[] glass;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		glass = new int[N];
		for(int i = 0; i < N; i++) glass[i] = Integer.parseInt(br.readLine());
		
		dfs(0, 0, 0);
		
		System.out.print(totalWine);
	}
	
	public static void dfs(int idx, int wine, int cnt) {
		if(idx == N-1) { 
			totalWine = Math.max(totalWine, wine);
			return;
		}
		
		if(cnt == 3) {
			dfs(idx+1, wine, 0);
		} else {
			dfs(idx+1, wine+glass[idx+1], cnt+1);
			dfs(idx+1, wine, 0);
		}
	}
 }
