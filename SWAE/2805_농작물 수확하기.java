package workshop;

// 2805_농작물 수확하기.java

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2805 {
	static int T, N, earn, index;
	static char[] farm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			earn = 0;
			index = 0;
			
			N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				
				farm = br.readLine().toCharArray();
				for(int j = N/2 - index; j <= N/2 + index; j++)
					earn += (farm[j] - '0');	
					
				if(i < N/2) index++;
				else index--;
			}
			System.out.println("#" + t + " " + earn);
		}
	}

}
