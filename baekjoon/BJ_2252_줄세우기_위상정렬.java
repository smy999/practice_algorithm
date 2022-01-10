package Jan_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_2252_줄세우기_위상정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 정점
		int M = Integer.parseInt(st.nextToken());	// 간선
		
		ArrayList<Integer>[] list = new ArrayList[N+1];	// 정점 연결 정보 저장 리스트
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		int[] target = new int[N+1];					// 진입차수 저장 배열
		
		for(int i = 0; i < M; i++) {				// 입력
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			target[node2]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();	// 탐색을 위한 큐 선언
		for(int i = 1; i <= N; i++) {				// 해당 노드로 몇개의 화살표가 있는지 계산하여 
			if(target[i] == 0) queue.add(i);		// 해당 노드를 가리키는 노드가 없으면 큐에 추가
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int node = queue.poll();		// 원소 꺼내기
			sb.append(node).append(" ");	// 순서 추가
			
			for(int i = 0; i < list[node].size(); i++) {
				int targetNode = list[node].get(i);	// 현재 노드를 가리키는 노드들에서 현재 노드 삭제
				if(--target[targetNode] == 0) queue.add(targetNode);	// 새롭게 진입차수가 0이된 노드들을 큐에 삽입
			}
		}
		
		System.out.print(sb);
	}
}
