
import java.io.*;
import java.util.StringTokenizer;

public class BJ_15661_링크와스타트 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[][] experience;
	static int[] link, start;
	static boolean[] select;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// 인원 수
		experience = new int[N+1][N+1];			// 검험치 배열
		select = new boolean[N];				// 원소 선택 배열
		
		for(int i = 1; i <= N; i++) {			// 경험치 입력
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
				experience[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++)				// 1명 ~ N-1명까지 조합
			divideSL(i, 0, 0);
		
		System.out.print(min);					// 결과 출력
	}
	
	static void divideSL(int n, int selectIdx, int number) {

		if(selectIdx == n) {
			// 팀 나누기
			link = new int[n];
			start = new int[N-n];
			int idxL = 0, idxS = 0;
			for(int i = 0; i < N; i++) {
				if(select[i] == true) link[idxL++] = i+1;
				else start[idxS++] = i+1;
			}
			
			// 능력치 차이 구하기
			int differ = Math.abs(getExprience(link) - getExprience(start));
			
			// 최소값 갱신
			min = (min > differ) ? differ : min;
			
			return;
		}
		
		if(number == N) return;
		
		select[number] = true;
		divideSL(n, selectIdx+1, number+1);
		select[number] = false;
		divideSL(n, selectIdx, number+1);
	}
	
	// 경험치 합 구하기
	static int getExprience(int[] arr) {
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				sum += experience[arr[i]][arr[j]] + experience[arr[j]][arr[i]];
			}
		}
		return sum;
	}
}
