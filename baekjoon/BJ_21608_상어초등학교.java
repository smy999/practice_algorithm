import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BJ_21608_상어초등학교 {

	static int N, studentNo;
	
	static int[][] bestFriends;
	static int[][] classroom;
	
	static PriorityQueue<int[]> pq = new PriorityQueue<>((q1, q2) -> {
		if(q1[0] == q2[0]) {
			if(q1[1] == q2[1]) {
				if(q1[2] == q2[2]) {
					return q1[3] - q2[3];	// 우선 순위 4: 열 값이 작은 것 부터 
				}
				return q1[2] - q2[2];	// 우선 순위 3: 행 값이 작은 것 부터
			}
			return q2[1] - q1[1];	// 우선 순위 2: 4바 안에 빈 자리가 있는 수
		}
		return q2[0] - q1[0];	// 우선 순위 1: 4방 안에 좋아하는 친구가 있는 수
	});
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		classroom = new int[N+1][N+1];	// 교실의 자리 배열(몇 번 학생이 앉을 것인가)
		
		int total = N*N;	// 총 인원 수

		bestFriends = new int[total+1][4];	// 각 학생이 좋아하는 학생들의 번호 저장 배열
		
		// 학생 정보를 하났기 입력받을 때마다 자리를 배정한다.
		for(int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 자리에 앉힐 학생 번호
			studentNo = Integer.parseInt(st.nextToken());	
			
			// 해당 학생이 좋아하는 학생들 배열에 저장
			for(int j = 0; j < 4; j++) {	
				bestFriends[studentNo][j] = Integer.parseInt(st.nextToken());
			}
			
			// 자리 배정 시작
			process();
		}
		
		System.out.print(getSatisfaction());
	}
	
	// 인접한 좋은 친구, 빈 칸 찾아서 우선순위 큐에 넣고, 자리 찾는 함수
	private static void process() {
		
		// classroom의 모든 자리를 탐색한다.
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				
				// 해당 위치에 이미 학생이 정해졌다면 다음 자리 탐색
				if(classroom[r][c] != 0) continue;
				
				// 빈 자리라면 인접한 좋은 친구 수, 인접한 빈 자리의 수를 구한다.
				// 인접한 좋은 친구의 수
				int bfCnt = findBF(r, c, studentNo);
				// 인접한 빈 자리의 수
				int emptyCnt = findEmpty(r, c);
				
				// 구한 정보를 큐에 저장해서 우선 순위에 맞게 정렬한다.
				pq.offer(new int[] {bfCnt, emptyCnt, r, c});
			}
		}
		
		// 탐색이 다 끝난 후, 큐에 제일 앞에 있는 자리 정보를 통해 자리를 배정한다.
		// 제일 앞에 있는 자리 정보 = 우선 순위가 제일 높은 자리
		int[] student = pq.poll();
		classroom[student[2]][student[3]] = studentNo;
		
		// 다음 학생의 자리배정에도 사용하기 위해 큐를 비운다.
		pq.clear();
	}
	
	// 인접한 좋아하는 친구 찾기
	private static int findBF(int r, int c, int n) {
		int bfCnt = 0;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 1 || nr > N || nc < 1 || nc > N) continue;
			
			for(int i = 0; i < 4; i++) {
				if(classroom[nr][nc] == bestFriends[n][i]) {
					bfCnt++;
					break;
				}
			}
		}
		
		return bfCnt;
	}
	
	// 인접한 빈칸 찾기
	private static int findEmpty(int r, int c) {
		int emptyCnt = 0;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 1 || nr > N || nc < 1 || nc > N) continue;
			
			for(int i = 0; i < 4; i++) {
				if(classroom[nr][nc] == 0) emptyCnt++;
			}
		}
		
		return emptyCnt;
	}
	
	// 만족도 구하기
	private static int getSatisfaction() {
		int sum = 0;
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				int bfCnt = findBF(r, c, classroom[r][c]);
				switch(bfCnt) {
				case 1: sum += 1; break;
				case 2: sum += 10; break;
				case 3: sum += 100; break;
				case 4: sum += 1000; break;
				}
			}
		}
		
		return sum;
	}

}
