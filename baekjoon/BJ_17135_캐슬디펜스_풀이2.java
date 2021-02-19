
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {
	
	static int N, M, D, max, killCnt;
	static int[][] battleField;
	static int[] archer = new int[3];
	static StringTokenizer st;
	
	// 배틀필드의 적들을 넣을 list
	static List<Enemy> enemy = new ArrayList<>();
	// 적들의 거리를 계산하여 거리순으로 정렬하고, 거리가 같다면 위치하는 열이 왼쪽에 가까운 순서로 정렬
	static PriorityQueue<Enemy> pqueue = new PriorityQueue<>(
			(p1, p2) -> p1.d == p2.d ? p1.c - p2.c : p1.d - p2.d);
	
	// 적들의 정보를 담은 class
	static class Enemy{
		public int r, c, d;
		public boolean isDead;
		
		public Enemy(int r, int c) {
			this.r = r; this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 행 수
		M = Integer.parseInt(st.nextToken());	// 열 수
		D = Integer.parseInt(st.nextToken());	// 제한 거리
		
		battleField = new int[N][M];
		
		// 배틀필드 입력
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				battleField[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 궁수 3명 자리 정하기
		selectArcher(0, 0);
		
		// 결과 출력
		System.out.print(max);
		
		br.close();	// 스트림 닫기
	}
	
	/* 궁수 3명의 자리를 정한 후 게임을 시작한다. */
	static void selectArcher(int archerIdx, int idx) {
		if(archerIdx == 3) {
			gameOn();
			return;
		}
		
		if(idx == M) return;
		
		archer[archerIdx] = idx;
		
		selectArcher(archerIdx + 1, idx + 1);
		selectArcher(archerIdx, idx + 1);
	}
	
	/* 게임 실행 부분 */
	static void gameOn() {
		// 적들의 정보를 담은 리스트
		enemy.clear();	// 초기화
		for(int r = 0; r < N; r++)
			for(int c = 0; c < M; c++)
				if(battleField[r][c] == 1) enemy.add(new Enemy(r, c));
		
		// 궁수와 적들이 번갈아 가며 공격한다.
		killCnt = 0;	// 한 게임에서 궁수가 죽이는 적의 수 초기화
		while(true) {
			// 3명의 궁수가 쏠 적을 정한다.
			for(int i = 0; i < 3; i++) {
				// 초기화
				pqueue.clear();	// 쏠 적의 거리 정보를 담아 우선순위로 정렬하는 우선순위 큐 초기화
				int ac = archer[i];	// 현재 궁수의 열 번호 저장
				
				// 거리를 계산하여 제한 거리 이하면 pqueue에 저장한다.
				for(int j = 0; j < enemy.size(); j++) {
					Enemy e = enemy.get(j);
					e.d = Math.abs(N - e.r) + Math.abs(ac - e.c);
					
					if(e.d <= D) pqueue.offer(e);
				}
				// 현재 궁수가 쏘 적이 있으면 pqueue에서 꺼내며 죽었다고 표시한다.
				if(!pqueue.isEmpty()) pqueue.poll().isDead = true;
			}
			
			// 죽은 적들의 수를 세며 성벽에 도달하는 적은 삭제하고, 죽지 않은 적은 한 칸 당긴다.
			Iterator<Enemy> iter = enemy.iterator(); // list의 값을 가져로오기 위한 iterator
			while(iter.hasNext()) {
				Enemy e = iter.next();
				if(e.isDead) {
					iter.remove();
					killCnt++;
				} else if(e.r == N-1) {
					iter.remove();
				} else {
					e.r++;
				}
			}
			
			// 적을 담은 리스트에 아무것도 없다면 반복문 탈출한다.
			if(enemy.size() == 0) break;
		}
		// 죽인 최대 적의 수를 갱신한다.
		max = Math.max(max, killCnt);
	}

}
