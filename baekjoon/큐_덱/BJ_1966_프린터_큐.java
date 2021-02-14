package 큐_덱;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class BJ_1966_프린터_큐 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();

		LinkedList<int[]> queue = new LinkedList<>();

		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());	// 문서의 개수
			int M = Integer.parseInt(st.nextToken());	// 해당 문서가 몇 번째에 놓여 있는지 나타내는 수
			
			st = new StringTokenizer(br.readLine());	// N개의 정수 입력

			// N개 정수의 초기 입력 위치와 정수 값 큐에 삽입
			for(int i = 0; i < N; i++) {				
				queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}

			int result = 0;				// 출력 순서
			
			while(!queue.isEmpty()) {
				
				int[] front = queue.poll();	// 맨 앞 정수 임시 저장
				boolean isMax = true;		// 맨 앞 정수가 최대 우선순위라고 가정
				
				for(int i = 0; i < queue.size(); i++) {
					if(front[1] < queue.get(i)[1]) {	// 맨 앞 정수보다 우선순위가 높은 요소가 있다면
						
						queue.offer(front);				// 맨 앞 정수 큐 맨 뒤에 삽입
						
						for(int j = 0; j < i; j++)		// 맨 앞 정수보다 작은 요소들 맨 뒤로 삽입
							queue.offer(queue.poll());
						
						isMax = false;					// 맨 앞 정수가 최대 우선순위가 아니라고 표시
						break;							// 반복문 나가기
					}
				}
				
				if(isMax == false) continue;// 맨 앞 정수가 최대 우선순위가 아니면 계속 검색
				
				result++;					// 맨 앞 정수가 최대 우선순위면 출력 순서 증가
				
				if(front[0] == M) break;	// 맨 앞 정수가 최대 우선수위이면서 타겟 문서이면 반복문 나가기
			}
			
			sb.append(result + "\n");		// 결과 출력
	
			queue.clear();					// 다음 테스트케이스 입력을 위한 큐 초기화
		}
		
		System.out.print(sb);

		// 스트림 닫아주기
		br.close();
	}
}
