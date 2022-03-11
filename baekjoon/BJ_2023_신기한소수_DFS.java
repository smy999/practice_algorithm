package Mar_week1_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2023_신기한소수_DFS {
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dfs(0, "");
		
		System.out.print(sb);
	}
	
	public static void dfs(int cnt, String num) {
		if(cnt == N) {
			sb.append(num).append("\n");
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			// 지금까지 만들어진 수가 소수일때만 다음 수 조합
			if(check(Integer.valueOf(num+i))) dfs(cnt+1, num+i);
		}
	}
	
	public static boolean check(int num) {
		if(num == 1) return false; // 1은 소수가 아니다.
		
		// 에라토스테네스의 체
		int sqrt = (int)Math.sqrt(num);
		for(int i = 2; i <= sqrt; i++) if(num % i == 0) return false;
		
		return true;
	}
}
