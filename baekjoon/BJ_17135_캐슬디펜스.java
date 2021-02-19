package workshop;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;

public class BJ_17135_캐슬디펜스 {

	static int N, M, D, kill, fill, max;
	static StringTokenizer st;
	static int[][] input;
	static int[][] map;

	static ArrayList<int[]> al = new ArrayList<>();
	static Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		input = new int[N+1][M];	// 입력한 원본 배열
		map = new int[N+1][M];		// 게임을 진행하며 바뀌는 배열

		for(int i = 0; i < N; i++) {// 배틀필드 입력
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = input[i][j];
			}
		}

		comb(0, 0);	// 가능한 게임 조합 만들기

		System.out.print(max);	// 결과 출력
	}

	static void comb(int idx, int archerIdx) {

		if(idx == 3) {	// 기저 조건
			kill = 0;	// 한 게임 당 궁수가 죽인 적의 수 초기화

			while(true) {
				// 초기화
				fill = 0;	// 적의 개수를 카운트해 배틀 필드가 비었는지 확인
				al.clear();	// 궁수 공격 턴에서 죽일 적의 좌표 저장하는 ArrayList

				// map[N-1] 맨 마지막 줄에서 궁수 찾아서 공격할 적 찾기
				for(int i = 0; i < M; i++)
					if(map[N][i] == 1) archerAttack(i);

				// 적 죽이기
				for(int i = 0; i < al.size(); i++) {	
					int[] tmp = al.get(i);// 적의 정보 받아오기
					map[tmp[0]][tmp[1]] = 0;// 공격한 적 0으로 변겅
					kill++;	// 공격하여 적을 죽인 후 킬포인트 증가
				}

				// 적의 공격: 한 칸 앞으로
				for(int i = N-2; i >= 0; i--) {
					for(int j = 0; j < M; j++) {
						if(map[i][j] == 1) fill++;
						map[i+1][j] = map[i][j];
					}
				}

				// 한칸 밑으로 이동한 후 맨 윗줄 0으로 초기화
				for(int i = 0; i < M; i++) map[0][i] = 0;

				// 배틀 필드에 적이 없으면 현재까지 궁수가 죽인 적의 수를 최대 kill와 비교하여 갱신
				if(fill == 0) {
					if(max < kill) max = kill;
					break;
				}
			}
			
			// map에 원본 배열 복사
			for(int i = 0; i < N; i++) 
				System.arraycopy(input[i], 0, map[i], 0, M);

			return;
		}

		if(archerIdx == M) return;

		map[N][archerIdx] = 1;		// 궁수 자리 선택O
		comb(idx+1, archerIdx+1);
		map[N][archerIdx] = 0;		// 궁수 자리 선택X
		comb(idx, archerIdx+1);

	}


	private static void archerAttack(int aj) {

		int dist = Integer.MAX_VALUE;

		for(int i = N-1; i >= 0; i--) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;	// 적이 아니면 이어서 적 탐색

				int tmp = Math.abs(N-i) + Math.abs(aj-j);

				if(tmp > D || dist < tmp) continue; // 궁수와 적 사이의 거리가 제한 거리(D)보다 크다면 다음 적 검색 

				if(dist == tmp && stack.peek()[1] < j) continue;// 거리가 같은데 오른쪽에 있으면 다음 적 탐색

				// 현재 적과 궁수의 거리가 이전 거리의 최소값보다 작으면 최소값 갱신
				dist = tmp;
				stack.push(new int[] {i, j});	

			}
		}
		if(stack.isEmpty()) return;	// 공격 가능한 적이 없으면 반환

		boolean contain = false;// 같은 적을 공격하는지 반판하는 변수

		for(int i = 0; i < al.size(); i++) {	// 같은 적을 공격하면 true, 아니면 false
			if(al.get(i)[0] == stack.peek()[0] && al.get(i)[1] == stack.peek()[1]) {
				contain = true;
				break;
			}
		}
		if(!contain) al.add(stack.pop()); // 제거 대상이 된 적의 중복 입력을 피하기 위해 해시셋 사용
		stack.clear();	
	}
}



/*
 * 
5 5 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1

3


5 5 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0

3


5 5 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0

5


5 5 5
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1

15


6 5 1
1 0 1 0 1
0 1 0 1 0
1 1 0 0 0
0 0 0 1 1
1 1 0 1 1
0 0 1 0 0

9

6 5 2
1 0 1 0 1
0 1 0 1 0
1 1 0 0 0
0 0 0 1 1
1 1 0 1 1
0 0 1 0 0

14
 */
