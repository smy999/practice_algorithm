package workshop;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9760_PokerGame {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_9760.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t= 1; t <= T; t++) {

			sb.append("#").append(t).append(" ");
			
			char[] cardS = new char[5];			
			int[] cardR = new int[5];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 5; i++) {
				String str = st.nextToken();
				cardS[i] = str.charAt(0);
				char chr = str.charAt(1);
				
				if(chr == 'A') cardR[i] = 1;
				else if(chr == 'T') cardR[i] = 10;
				else if(chr == 'J') cardR[i] = 11;
				else if(chr == 'Q') cardR[i] = 12;
				else if(chr == 'K') cardR[i] = 13;
				else cardR[i] = chr - '0';
			}
			
			Arrays.sort(cardS);
			Arrays.sort(cardR);
			
			boolean straight = false;
			boolean flush = false;
			
			// 5. Straight
			int idx = 0;
			int num = cardR[0];
			for(; idx < 5; idx++) {
				if(cardR[idx] != num++) break;
			}
			if(idx == 5) straight = true;
			
			// 4. Flush
			if(cardS[0] == cardS[4]) flush = true;
			
			// 1. Straight Flush
			if(straight && flush) {
				sb.append("Straight Flush").append("\n");
				continue;
			}
			if(straight) {
				sb.append("Straight").append("\n");
				continue;
			}
			if(flush) {
				sb.append("Flush").append("\n");
				continue;
			}
			
			// 2. Four of a Kind
			if(cardR[0] == cardR[3] || cardR[1] == cardR[4]) {
				sb.append("Four of a Kind").append("\n");
				continue;
			}
			
			// 3. Full House
			if((cardR[0] == cardR[2] && cardR[3] == cardR[4]) 
					|| (cardR[0] == cardR[1] && cardR[2] == cardR[4])) {
				sb.append("Full House").append("\n");
				continue;
			}
			
			// 6. Three of a kind
			if(cardR[0] == cardR[2] || cardR[2] == cardR[4] || cardR[1] == cardR[3]) {
				sb.append("Three of a kind").append("\n");
				continue;
			}
			
			// 7. Two pair
			if(cardR[0] == cardR[1] && cardR[2] == cardR[3]) {
				sb.append("Two pair").append("\n");
				continue;
			}
			if(cardR[0] == cardR[1] && cardR[3] == cardR[4]) {
				sb.append("Two pair").append("\n");
				continue;
			}
			if(cardR[1] == cardR[2] && cardR[3] == cardR[4]) {
				sb.append("Two pair").append("\n");
				continue;
			}
			
			// 8. One pair
			if(cardR[0] == cardR[1] || cardR[1] == cardR[2] 
					|| cardR[2] == cardR[3] || cardR[3] == cardR[4]) {
				sb.append("One pair").append("\n");
				continue;
			}
			
			// 9. High card
			sb.append("High card").append("\n");
			
		}
		
		System.out.print(sb);
	}
}
