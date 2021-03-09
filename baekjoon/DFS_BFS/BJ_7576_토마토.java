
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_7576_토마토 {

	static int M, N, boxCnt, empty, day, len;
	static int[][] box;
	static ArrayList<int[]> list = new ArrayList<>();
	static Queue<int[]> queue = new LinkedList<>();

	// delta: 상, 우, 하, 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 0) empty++;
				else if(box[i][j] == 1) queue.add(new int[] {i, j});	// 익은 토마토를 큐에 입력
			}
		}

		while(!queue.isEmpty()) {
			int[] temp = queue.poll();	// 큐에서 하나씩 꺼내어 탐색 시작
			
			for(int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];

				if(nr < 0 || nr >= N || nc < 0 || nc >= M || box[nr][nc] != 0) continue;

				// 하댕 방향에 안익은 토마토가 있다면 box의 상태 변경, 큐에 넣기, 안익은 토마토 수 감소
				box[nr][nc] = box[temp[0]][temp[1]]+1;
				queue.add(new int[] {nr, nc});
				empty--;
			}
		}
		
		if(empty != 0) {	// 안익은 토마토가 아직 남아있을 때
			day = -1;
		} else {	// 가장 마지막에 익은 토마토를 찾는다.
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					day = Math.max(day, box[i][j]);
			day--;	// 1부터 시작했으니 1 빼준다.
		}

		System.out.print(day);
	}
}
