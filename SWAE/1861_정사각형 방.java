package workshop;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import com.sun.org.apache.bcel.internal.classfile.Node;

// SWEA_1861 정사각형 방
// move = dfs

public class SWEA_1861 {

	static int T, N, COUNT, NO;
	static int[][] A;

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {

			COUNT = 1;
			NO = 0;

			N = Integer.parseInt(br.readLine());

			A = new int[N][N];

			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());	
				
				for(int j = 0; j < N; j++)
					A[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++)		
				for(int j = 0; j < N; j++)
					move(i, j, A[i][j], 1);

			System.out.println("#" + t + " " + NO + " " + COUNT);
		}
	}

	private static void move(int y, int x, int no, int cnt) {

		// 방문횟수 계산
		if(cnt > COUNT) {
			COUNT = cnt;
			NO = no;
		} else if (cnt == COUNT) {
			NO = (no < NO) ? no : NO;
		}

		for(int d = 0; d < 4; d++) {

			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || A[ny][nx] != A[y][x]+1) continue;

			move(ny, nx, no, cnt+1);
		}
	}
}

