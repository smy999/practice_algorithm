package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기_DFS {

	static int N, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
	static int[] operand, operator;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		operand = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
		
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, operand[0]);
		
		System.out.print(max + "\n" + min);
	}
	
	public static void dfs(int idx, int ans) {
		if(idx == N) {
			min = Math.min(min, ans);
			max = Math.max(max, ans);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] == 0) continue;
			
			operator[i]--;
			switch(i) {
			case 0: dfs(idx+1, ans+operand[idx]); break;
			case 1: dfs(idx+1, ans-operand[idx]); break;
			case 2: dfs(idx+1, ans*operand[idx]); break;
			case 3: dfs(idx+1, ans/operand[idx]); break;
			}
			operator[i]++;
		}
	}
}
