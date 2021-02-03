package workshop;

1873_상호의 배틀필드.java

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1873 {
	static int T, H, W, N, curX, curY;
	static char[][] map;
	static int direction;
	static char[] move;
	static int[] dx = {0, 0, -1, 1};	// 상, 하, 좌, 우
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// test case 입력, 입력 값만큼 반복
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {

			// 높이, 너비 입력 및 배열 생성
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][];
			for(int i = 0; i < H; i++)
				map[i] = br.readLine().toCharArray();		
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == '^') {direction = 0; curX = j; curY = i; break;}
					else if(map[i][j] == 'v') {direction = 1; curX = j; curY = i; break;}
					else if(map[i][j] == '<') {direction = 2; curX = j; curY = i; break;}
					else if(map[i][j] == '>') {direction = 3; curX = j; curY = i; break;}
				}
			}

			N = Integer.parseInt(br.readLine());
			move = br.readLine().toCharArray();

			for(int n = 0; n < N; n++) {
				switch(move[n]) {
				case 'U': 
					direction = 0; 
					map[curY][curX] = '^';
					tankMove(); 
					break;
				case 'D': 
					direction = 1; 
					map[curY][curX] = 'v';
					tankMove(); 
					break;
				case 'L': 
					direction = 2; 
					map[curY][curX] = '<';
					tankMove(); 
					break;
				case 'R': 
					direction = 3; 
					map[curY][curX] = '>';
					tankMove(); 
					break;
				case 'S': 
					tankShoot(); 
					break;

				}
			}

			// 결과 출력
			System.out.print("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}
		
	}

	static void tankMove() {
		int nx = curX + dx[direction];
		int ny = curY + dy[direction];
		
		if(nx < 0 || nx >= W || ny < 0 || ny >= H) return;
		
		if(map[ny][nx] == '.') {
			map[ny][nx] = map[curY][curX];
			map[curY][curX] = '.';
			curX = nx; curY = ny;
		}

	}

	static void tankShoot() {
		int nx = curX;
		int ny = curY;
		while(true) {
			nx = nx + dx[direction];
			ny = ny + dy[direction];
			
			if(nx < 0 || nx >= W || ny < 0 || ny >= H) return;

			if(map[ny][nx] == '*') {
				map[ny][nx] = '.';
				return;
			}
			else if(map[ny][nx] == '#') { 
				return;
			} 
		}
	}
}
