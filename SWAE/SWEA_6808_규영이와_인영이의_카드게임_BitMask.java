package workshop;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와_인영이의_카드게임_BitMask {
	// 1 ~ 18까지의 카드
	// 9장씩 나눠 가진다.
	// 한 장씩 낸 다음 두 사람이 낸 카드에 적힌 수 비교해서 점수 계산
	// 높은 카드 점수 = 두 카드의 합, 낮은 카드 점수 = 0
	// 9개의 게임에서 점수가 높은 사람이 이긴다. 총점이 같으면 무승부!
	// 규영이가 이기고, 지는 경우 총 몇가지인지 구하는 프로그램
	
	static int winCnt, loseCnt;	   // 규영이가 이긴 횟수, 진 횟수
	
	static int[] gyu = new int[9]; // 규영 카드 목록
	static int[] you = new int[9]; // 인영 카드 목록(모든 경우의 수)
	static int[] src = new int[9]; // 초기 인영 카드 목록
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
			
			permutation(0, 0);
			
			sb.append(winCnt + " " + loseCnt);
			if(t != T) sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
	
	static void permutation(int youIdx, int flag) {
		
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
			if((flag & 1<<i) != 0) continue;
			
			you[youIdx] = src[i];

			permutation(youIdx+1, flag | 1<<i);
		}
	}
}
