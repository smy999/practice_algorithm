package Workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20055_컨베이어벨트위의로봇 {

	static int N, K, step;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belt = new int[2 * N];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {

			// 1. 벨트가 한칸 회전한다.
			rotate();

			// 2. 가장 먼저 벨트에 올라간 로봇부터 벨트가 회전하는 방향으로 한칸 이동할 수 있다면 이동한다.
			move();

			// 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
			if (!robot[0] && belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}

			step++;
			
			if(findZero() >= K) break;
			
		}

		System.out.print(step);
	}

	private static void move() {
		
		for (int i = N-2; i >= 0; i--) {
			
			if (robot[i] && !robot[i+1] && belt[i+1] > 0) {
				robot[i] = false; // 원래 로봇이 있던 자리에서 로봇이 없음을 표시
				robot[i+1] = true; // 로봇을 이동시킨 벨트칸에 로봇이 있음을 표시
				belt[i+1]--; // 이동한 후의 벨트칸 내구성 감소
			}
		}
	}

	private static void rotate() {
		int tmp = belt[(2 * N) - 1];
		for (int i = 2*N-1; i > 0 ; i--) {
			belt[i] = belt[i-1];
		}
		// 2N-1를 0으로
		belt[0] = tmp;

		for (int i = N - 1; i > 0 ; i--) {
			robot[i] = robot[i-1];
		}
		// 회전 후 첫 벨트칸은 항상 로봇이 없다.
		robot[0] = false;
		// N-1 로봇 내리기
		robot[N-1] = false; 
	}

	private static int findZero() {
		int cnt = 0;
		for (int i = 0; i < 2 * N; i++) {
			if (belt[i] <= 0) cnt++;
		}
		return cnt;
	}
}
