import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_17143_낚시왕_sol {

	static int R, C, M, sum;
	static Shark[][] map;
	static ArrayList<Shark> list = new ArrayList<>();
	
	// 상, 하, 우, 좌
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	// 상어: 번호, 위치R, 위치C, 속도, 방향, 크기
	static class Shark {
		int n, r, c, s, d, z;
		public Shark(int n, int r, int c, int s, int d, int z) {
			this.n = n;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R+1][C+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(i+1, r, c, s, d-1, z);
			map[r][c] = shark;
			list.add(shark);
		}	// 입력
		
		// 시뮬레이션
		for(int i = 1; i <= C; i++) {
			// 1. 상어 잡기
			catchShark(i);
			
			// 2. 상어 이동
			moveShark();
			
			// 3. 같은 자리 상어들 정리
			arrangShark();
		}
		
		// 결과 출력
		System.out.print(sum);
	}
	
	private static void arrangShark() {
		map = new Shark[R+1][C+1];
		int size = list.size();
		
		// 뒤부터 접근하는 이유: remove에 의한 index 오류 해결
		for(int i = size-1; i >= 0; i--) {	
			Shark s = list.get(i);
			
			if(map[s.r][s.c] == null) {
				map[s.r][s.c] = s;
			}
			else {
				if(map[s.r][s.c].z < s.z) {
					list.remove(map[s.r][s.c]);
					map[s.r][s.c] = s; 
				}
				else {
					list.remove(i);
				}
			}
		}
	}
	
	private static void moveShark() {
		for(Shark shark : list) {
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;
			int z = shark.z;
			
			switch(d) {
			case 0:
			case 1:
				s = s%(R*2-2); // 5칸 기준으로 8칸 이동하면 제자리 >> R번 이상이면 나눠서 적게 움직이도록
				for(int i = 0; i < s; i++) {
					if(r == 1) d = 1;
					else if(r == R) d = 0;
					r += dr[d];
				}
				shark.r = r;
				shark.d = d;
				break;
			case 2:
			case 3:
				s = s%(C*2-2); // C번 이상이면 나눠서 적게 움직이도록
				for(int i = 0; i < s; i++) {
					if(c == 1) d = 2;
					else if(c == C) d = 3;
					c += dc[d];
				}
				shark.c = c;
				shark.d = d;
				break;
			}
		}
	}
	
	private static void catchShark(int c) {
		for(int i = 1; i <= R; i++) {
			if(map[i][c] != null) {	
				// 점수
				sum += map[i][c].z;
				// 삭제
				list.remove(map[i][c]);
				break;
			}
		}
	}
}
