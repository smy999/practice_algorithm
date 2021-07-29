package July_week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499_주사위굴리기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 동>서>남>북
		int[] dr = {0, 0, 0, -1, 1};
		int[] dc = {0, 1, -1, 0, 0};
		// 주사위 초기 설정은 모두 0
		int[] dice = {0, 0, 0, 0, 0, 0, 0};
		// 결과를 담을 sb
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			
			int nr = R + dr[dir];
			int nc = C + dc[dir];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			int[] newDice = dice.clone();
			
			switch(dir) {
			case 1: dice[1]=newDice[4]; dice[3]=newDice[1]; dice[4]=newDice[6]; dice[6]=newDice[3]; break;
			case 2: dice[1]=newDice[3]; dice[3]=newDice[6]; dice[4]=newDice[1]; dice[6]=newDice[4]; break;
			case 3: dice[1]=newDice[5]; dice[2]=newDice[1]; dice[5]=newDice[6]; dice[6]=newDice[2]; break;
			case 4: dice[1]=newDice[2]; dice[2]=newDice[6]; dice[5]=newDice[1]; dice[6]=newDice[5]; break;
			}
			
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice[6];
			} else {
				dice[6] = map[nr][nc]; 
				map[nr][nc] = 0;
			}
			
			sb.append(dice[1]).append("\n");
			
			R = nr; C = nc;
		}
		
		System.out.print(sb);
	}
}
