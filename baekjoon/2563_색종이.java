package hwalgo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이 {
	
	static int N, coloredArea, maxX, maxY;
	static int[][] whitePaper;
	static int[][] coloredPaper;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		coloredPaper = new int [N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coloredPaper[i][0] = Integer.parseInt(st.nextToken());
			coloredPaper[i][1] = Integer.parseInt(st.nextToken());
			
			if(maxX < coloredPaper[i][0]) maxX = coloredPaper[i][0];
			if(maxY < coloredPaper[i][1]) maxY = coloredPaper[i][1];
		}
		
		whitePaper = new int[maxX+10][maxY+10];
		
		for(int n = 0; n < N; n++)
			for(int i = coloredPaper[n][0]; i < coloredPaper[n][0] + 10; i++)
				for(int j = coloredPaper[n][1]; j < coloredPaper[n][1] + 10; j++)
					whitePaper[i][j] = 1;

		
		for(int i = 0; i < maxX + 10; i++)
			for(int j = 0; j < maxY + 10; j++)
				if (whitePaper[i][j] == 1) coloredArea++;
		
		System.out.println(coloredArea);
	}
}


/*
input

3
3 7
15 7
5 2


output

260

*/
