import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_4013_특이한자석_sol {

	static int K, ans;
	static int[] score = {1, 2, 4, 8};	// 자석 점수
	static int[] direction;	// 자석별로 움직여야 하는 방향
	static int[][] gear;	// 자석
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input_4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int K = Integer.parseInt(br.readLine());
			
			gear = new int[4][8];
			
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// K 만큼 회전
			for(int k = 0; k < K; k++) {
				// 자석 번호, 방향
				st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				// 움직이는 자석과 날개의 현재 값 = 어느 자석의 어떤 방향으로 움직여야 하는지
				check(id, dir);
				
				// 자석 4개를 하나씩 회전
				for(int j = 0; j < 4; j++) {
					move(j);
				}
			}
		
			// 점수 부여
			ans = 0;
			for(int i = 0; i < 4; i++) {
				if(gear[i][0] == 1) ans+= score[i];
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		
		}	// Test Case
		
		System.out.print(sb);
	}
	
	static void move(int id) {
		
		int tmp = 0;
		
		switch(direction[id]) {
		case 1:	// 시계 방향
			tmp = gear[id][7];
			for(int i = 7; i > 0; i--) {
				gear[id][i] = gear[id][i-1];
			}
			gear[id][0] = tmp;
			break;
		case -1: // 반시계 방향
			tmp = gear[id][0];
			for(int i = 0; i < 7; i++) {
				gear[id][i] = gear[id][i+1];
			}
			gear[id][7] = tmp;
			break;
		}
	}
	
	static void check(int id, int dir) {
		direction = new int[4];
		direction[id] = dir;
		
		// 오른쪽
		for(int i = id+1; i < 4; i++) {
			if(gear[i-1][2] != gear[i][6]) {
				direction[i] = direction[i-1] * (-1);
			}
		}
		
		// 왼쪽
		for(int i = id-1; i >= 0; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				direction[i] = direction[i+1] * (-1);
			}
		}
	}
}
