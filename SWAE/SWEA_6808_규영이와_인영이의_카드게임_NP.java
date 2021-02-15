package workshop;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와_인영이의_카드게임_NP {
	// 1 ~ 18까지의 카드
	// 9장씩 나눠 가진다.
	// 한 장씩 낸 다음 두 사람이 낸 카드에 적힌 수 비교해서 점수 계산
	// 높은 카드 점수 = 두 카드의 합, 낮은 카드 점수 = 0
	// 9개의 게임에서 점수가 높은 사람이 이긴다. 총점이 같으면 무승부!
	// 규영이가 이기고, 지는 경우 총 몇가지인지 구하는 프로그램

	static int winCnt, loseCnt;
	
	static int[] gyu = new int[9]; 
	static int[] you = new int[9];	// 규영이가 갖는 카드는 제시된다.
	
	static boolean[] check;
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	// 순열을 만든 후 제시한다. > 9!이다.

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input_6808.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			sb = new StringBuilder("#" + t + " ");
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
					if(!check[i]) you[idx++] = i;
			
			Arrays.sort(you);
			
			while(true) {

				int gyuScore = 0;
				int youScore = 0;

				for(int i = 0; i < 9; i++) {
					if(gyu[i] > you[i]) gyuScore += (gyu[i] + you[i]);
					else if(gyu[i] < you[i]) youScore += (gyu[i] + you[i]);
				}

				if(gyuScore > youScore) winCnt++;
				else if(gyuScore < youScore) loseCnt++;

				if(!nextPerm()) break;
			}

			sb.append(winCnt + " " + loseCnt);

			if(t != T) sb.append("\n");

			System.out.print(sb);
		}


		br.close();
	}

	static boolean nextPerm() {

		int i = 9 - 1;
		while( i > 0 && you[i-1] >= you[i]) --i;

		if(i == 0) return false;

		int j = 9 -1;
		while(you[i-1] >= you[j]) --j;

		swap(you, i-1, j);

		int k = 9 - 1;
		while( i < k ) swap(you, i++, k--);

		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
