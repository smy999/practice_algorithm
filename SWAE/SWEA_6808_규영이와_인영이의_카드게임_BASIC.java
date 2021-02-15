package workshop;

import java.io.*;
import java.util.StringTokenizer;

// 풀이2: 순열 재귀 구현

public class SWEA_6808_규영이와_인영이의_카드게임_BASIC {
	
	static int winCnt, loseCnt;	   // 규영이가 이긴 횟수, 진 횟수
	
	static int[] gyu = new int[9]; // 규영 카드 목록
	static int[] you = new int[9]; // 인영 카드 목록(모든 경우의 수)
	static int[] src = new int[9]; // 초기 인영 카드 목록
	static boolean[] isSelected = new boolean[9];
	static boolean[] check;		   // 규영이의 카드 숫자 check
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input_6808.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			winCnt = 0;
			loseCnt = 0;
			
			st = new StringTokenizer(br.readLine());
			
			check = new boolean[19];
			
			for(int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				check[gyu[i]] = true;
			}
		
			int idx = 0;
			for(int i = 1; i <= 18; i++)
					if(!check[i]) src[idx++] = i;
			
			permutation(0);
			
			sb.append(winCnt + " " + loseCnt);
			if(t != T) sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
	
	static void permutation(int youIdx) {
		
		if(youIdx == 9) {
			int gyuScore = 0;
			int youScore = 0;
			
			for(int i = 0; i < 9; i++) {
				if(gyu[i] > you[i]) gyuScore += (gyu[i] + you[i]);
				else if(gyu[i] < you[i]) youScore += (gyu[i] + you[i]);
			}
			
			if(gyuScore > youScore) winCnt++;
			else if(gyuScore < youScore) loseCnt++;
			
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(isSelected[i] == true) continue;
			
			you[youIdx] = src[i];
			isSelected[i] = true;
			permutation(youIdx+1);
			isSelected[i] = false;
		}
	}
}
