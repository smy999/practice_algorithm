import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_4013_특이한자석 {

	static int[][] magnet;
	static Queue<Info> queue = new LinkedList<>();
	static class Info {
		int magNo, dir;
		public Info(int magNo, int dir) {
			this.magNo = magNo;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			int K = Integer.parseInt(br.readLine());
			
			magnet = new int[4][8];
			
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int magNo = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				queue.add(new Info(magNo, dir));
				
				int dirT = dir;
				for(int i = magNo; i > 0; i--) {
					if(magnet[i-1][2] + magnet[i][6] == 1) {
						dirT *= -1;
						queue.add(new Info(i-1, dirT));
					}
					else break;
				}
				
				dirT = dir;
				for(int i = magNo+1; i < 4; i++) {
					if(magnet[i-1][2] + magnet[i][6] == 1) {
						dirT *= -1;
						queue.add(new Info(i, dirT));
					}
					else break;
				}
			
				rotate();
			}
			
			int multi = 1;
			int score = 0;
			for(int i = 0; i < 4; i++, multi*=2) {
				if(magnet[i][0] == 0) continue;
				else score += multi;
			}
			
			sb.append("#").append(t).append(" ").append(score).append("\n");
		
		}	// Test Case
		
		System.out.print(sb);
	}
	
	private static void rotate() {
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			int magNo = info.magNo;
			int dir = info.dir;
			
			if(dir == 1) {
				int last = magnet[magNo][7];
				for(int i = 7; i > 0; i--) {
					magnet[magNo][i] = magnet[magNo][i-1];
				}
				magnet[magNo][0] = last;
			}
			else {
				int first = magnet[magNo][0];
				for(int i = 0; i < 7; i++) {
					magnet[magNo][i] = magnet[magNo][i+1];
				}
				magnet[magNo][7] = first;
			}
		}
	}
}


/*

// 첫번째 자석을 움직일 때
int dirT = dir;
if(magNo == 0) {
	for(int i = 1; i < 4; i++) {
		if(magnet[i-1][2] + magnet[i][6] == 1) {
			dirT *= -1;
			queue.add(new Info(i, dirT));
		}
		else break;
	}
}
// 마지막 자석을 움직일 때

else if(magNo == 3) {
	dirT = dir;
	for(int i = 3; i > 0; i--) {
		if(magnet[i-1][2] + magnet[i][6] == 1) {
			dirT *= -1;
			queue.add(new Info(i-1, dirT));
		}
		else break;
	}
}
// 2, 3번째 자석을 움직일 때

else {
	dirT = dir;
	for(int i = magNo; i > 0; i--) {
		if(magnet[i-1][2] + magnet[i][6] == 1) {
			dirT *= -1;
			queue.add(new Info(i-1, dirT));
		}
		else break;
	}
	dirT = dir;
	for(int i = magNo+1; i < 4; i++) {
		if(magnet[i-1][2] + magnet[i][6] == 1) {
			dirT *= -1;
			queue.add(new Info(i, dirT));
		}
		else break;
	}
}
				
				*/
