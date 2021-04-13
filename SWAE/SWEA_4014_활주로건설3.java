package Youtube;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설3 {

	static int N, X, totalAirstrip;
	static boolean installable;
	static int[][] cliffsR, cliffsC;
	static boolean[][] installed;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			totalAirstrip = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			cliffsR = new int[N][N];
			cliffsC = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cliffsR[i][j] = cliffsC[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(t).append(" ").append(process()).append("\n");
			
		}	// for T
		
		System.out.println(sb);
		
	} 	// main

	private static int process() {
		
		int count = 0;
		
		// 상하, 좌우 검사를 반복문 하나로 합치자
		for(int i = 0; i < N; i++) {
			if(makeRoad(cliffsR[i])) count++;
			if(makeRoad(cliffsC[i])) count++;
		}
		
		return count;
	}

	private static boolean makeRoad(int[] cliffs) {
		
		int beforeHeight = cliffs[0];
		int size = 0;	// 연속된 동일 높이
		int j = 0;	// 탐색 열 위치
		
		while(j < N) {
			// 동일 높이의 연속 길이
			if(beforeHeight == cliffs[j]) {
				size++;
				j++;
			} 
			// 앞보다 뒤가 1칸 낮을 때
			else if(beforeHeight + 1 == cliffs[j]) { // 오르막 경사로 설치 가능 여부 판단
				// 경사로 설치 불가
				if(size < X) return false;
				
				// 경사로 설치 가능
				beforeHeight++;
				size = 1;
				j++;
			}
			// 뒤가 앞보다 1간 높을 때
			else if(beforeHeight - 1 == cliffs[j]) { // 내리막 경사로 설치 가능 여부 판단
				// 연속된 동일 높이 저장 변수
				int count = 0;
				
				// 연속 동일 높이 찾기
				for(int k = j; k < N; k++) {
					if(cliffs[k] != beforeHeight-1) break;
					if(++count == X) break;
				}
				
				// 경사로 설치 불가
				if(count < X) return false;
				
				// 경사로 설치 가능
				beforeHeight--;
				size = 0;
				j += X;
			}
			// 높이 차이가 2이상 날 때
			else {
				return false;
			}
		}
		
		return true;
	}
	
} // class
