package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_14888_연산자끼워넣기_Permutation {

	// 피연산자 개수, 연산자 개수, 최소값, 최대값
	static int N, M, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
	static int[] operand;		// 피연산자 배열
	static ArrayList<Integer> operatorSrc = new ArrayList<>();	// 연산자 리스트
	static int[] operatorTgt;	// 연산자 배열(순열)
	static boolean[] visited;	// 방문 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		operand = new int[N];
		
		// 피연산자 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		for(int i = 0; i < plus; i++) operatorSrc.add(1);
		int minus = Integer.parseInt(st.nextToken());
		for(int i = 0; i < minus; i++) operatorSrc.add(2);
		int multi = Integer.parseInt(st.nextToken());
		for(int i = 0; i < multi; i++) operatorSrc.add(3);
		int divide = Integer.parseInt(st.nextToken());
		for(int i = 0; i < divide; i++) operatorSrc.add(4);
		
		M = N-1;
		operatorTgt = new int[M];
		visited = new boolean[M];
		
		// 순열 만들기
		perm(0);
		
		System.out.print(max + "\n" + min);
	}
	
	public static void perm(int cnt) {
		// M개 중에 M개의 순서
		if(cnt == M) {
			getMinMax();	// 최대 최소 구하기
			return;
		}
		
		for(int i = 0; i < M; i++) {
			if(visited[i]) continue;
			
			operatorTgt[cnt] = operatorSrc.get(i);
			visited[i] = true;
			
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void getMinMax() {
		int ans = operand[0];
		
		for(int i = 0; i < M; i++) {
			switch(operatorTgt[i]) {
			case 1: ans += operand[i+1]; break;
			case 2: ans -= operand[i+1]; break;
			case 3: ans *= operand[i+1]; break;
			case 4: ans /= operand[i+1]; break;
			}
		}
		
		min = Math.min(min, ans);
		max = Math.max(max, ans);
	}
}
