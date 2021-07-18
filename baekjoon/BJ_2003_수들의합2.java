package July_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003_수들의합2 {

	static int N, M, start, end, sum, cnt;
	static int[] seq;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		seq = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) seq[i] = Integer.parseInt(st.nextToken());
		
		while(true) {
			if(sum >= M) sum -= seq[start++];	// 합이 M을 넘었으면 맨 앞의 숫자를 뺀다.
			else if(end == N) break;			// 끝까지 다 검사했다면 반복문 나간다.
			else sum += seq[end++];
			
			if(sum == M) cnt++;
		}
		
		System.out.print(cnt);
	}
}
