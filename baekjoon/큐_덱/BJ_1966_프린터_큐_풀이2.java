package 큐_덱;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;

public class BJ_1966_프린터_큐_풀이2 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		LinkedList<Integer> queue = new LinkedList<>();

		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());	// 문서의 개수
			int M = Integer.parseInt(st.nextToken());	// 해당 문서가 몇 번째에 놓여 있는지 나타내는 수
			
			int[] sort = new int[N];					// N개의 정수를 정렬하여 따로 저장할 배열
			
			st = new StringTokenizer(br.readLine());	// N개의 정수 입력

			// N개의 정수 입력
			for(int i = 0; i < N; i++) {				
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				sort[i] = num;
			}

			int result = 0;				// 타겟 문서가 출력되는 순서
			boolean isTarget = false;	// 타겟이 출력되었는지 확인하는 변수

			Arrays.sort(sort);			// 입력 정수 오름차순으로 정렬

			// 타겟 정수 출력 순서 구하기
			for(int i = N-1; i >= 0; i--) {

				while(!queue.isEmpty()) {
					// 1. 큐의 맨 앞 값이 출력 대상일 때
					if(sort[i] == queue.peek()) {
						
						queue.poll();				// 출력(맨 앞에서 제거)
						
						result++;					// 출력 순서 증가

						if(M == 0) isTarget = true; // 타겟이 출력 대상이라면 타겟 출력 확인 변수 true로 변경
						else M--;					// 타겟이 출력 대상이 아니면 앞으로 한 칸 이동
						
						break;						// 반복문 탈출
					}
					// 2. 큐의 맨 앞 값이 출력 대상이 아닐 때
					else {
						queue.offer(queue.poll());	// 큐의 맨 앞 정수를 마지막으로 이동
						
						if(M == 0) M = queue.size()-1;			// 타겟 위치 마지막(N-1)으로 이동
						else M--;					// 타겟이 출력 대상이 아니면 앞으로 한 칸 이동
					}
				}
				
				if(isTarget) break;		// 타겟이 출력되었다면 반복분 종료
			}

			bw.write(result + "\n");	// 타겟의 출력 순서 출력
	
			queue.clear();				// 큐 초기화
		}

		// 스트림 닫아주기
		br.close();
		bw.flush();
		bw.close();
	}
}
