package workshop;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class SWEA_2115_벌꿀채취 {

	static int N, M, C, maxSum = 0;
	static int[][] map;
	static int[] Row;
	static int[][] Col;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(t).append(" ").append(getMaxBenefit()).append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static int getMaxBenefit() {
		return proccessComb();
	}
	
	/* 추가: 부분집합의 합을 memoi를 활용하여 구현해보자 */
	private static int proccessComb() {
		
		int result = 0, aBenefit = 0, bBenefit = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= N-M; j++) {	// 첫 열부터 연속된 M개 채취가 가능한 열까지, 일꾼 A의 선택
				
				// 선택된 M개의 벌통에서 얻을 수 있는 최대 이익 구하기 => makeMaxSubSet
				
				// * 일꾼 A의 선택(A를 고정한 후 B의 모든 경우를 해본다.)
				maxSum = 0;
				makeMaxSubSet(i, j, 0, 0, 0);
				aBenefit = maxSum;
				
				// * 일꾼 B의 선택
				// 1) 일꾼 A와 같은 행에서 선택
				maxSum = 0;
				bBenefit = 0;
				for(int j2 = j+M; j2 <= N-M; j2++) {
					makeMaxSubSet(i, j2, 0, 0, 0);
					if(bBenefit < maxSum) bBenefit = maxSum;
				}
				
				// 2) 일꾼 A의 다음 행부터 선택
				maxSum = 0;
				for(int i2 = i+1; i2 < N; i2++) {
					for(int j2 = 0; j2 <= N-M; j2++) {
						makeMaxSubSet(i2, j2, 0, 0, 0);
						if(bBenefit < maxSum) bBenefit = maxSum;
					}
				}
				if(result < aBenefit+bBenefit) result = aBenefit+bBenefit;
			}
		}
		
		return result;
	}
	
	private static void makeMaxSubSet(int i, int j, int cnt, int sum, int powerSum) {
		
		// 가지치기
		if(sum > C) return;
		
		// 기저: 모든 원소까지 다 부분집합에 고려해봤다면
		if(cnt == M) {
 			if(maxSum < powerSum) maxSum = powerSum;
			return;
		}
		
		// 선택
		makeMaxSubSet(i, j+1, cnt+1, sum+map[i][j], powerSum+(map[i][j]*map[i][j]));
		// 비선택
		makeMaxSubSet(i, j+1, cnt+1, sum, powerSum);
	}
}
