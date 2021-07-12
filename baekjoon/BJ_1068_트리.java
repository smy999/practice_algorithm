package July_weak2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1068_트리 {

	static int N, D, cnt;
	static int[][] node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 노드의 개수
		N = Integer.parseInt(br.readLine());
		
		// 	해당 노드의 부모와 자식의 개수를 저장할 배열 선언
		node = new int[N][2];
		
		// 모든 노드의 부모들 입력
		st = new StringTokenizer(br.readLine());	
		
		for(int i = 0; i < N; i++) {
			// i번째 노드의 부모 입력
			int parent = Integer.parseInt(st.nextToken());
			// 부모가 있으면 해당 노드의 부모 저장
			node[i][0] = parent;
			// 부모가 없으면 다음 노드의 부모 입력
			if(parent == -1) continue;
			// 부모 노드가 갖는 자식의 수 증가
			node[parent][1]++;	
		}
		
		// 지울 노드 번호 입력
		D = Integer.parseInt(br.readLine());

		remove(D);	// 노드 지우기
		
		count();	// 리프 노드 카운트
		
		System.out.print(cnt);	// 결과 출력
	}
	
	public static void remove(int d) {
		// d 노드의 부모 노드 가져오기
		int parent = node[d][0];			
		
		// 루트 노드가 아니면 부모와 절연
		if(parent != -1) node[parent][1]--;	
		
		node[d][0] = -2;	// 없는 노드 표시
		
		if(node[d][1] > 0) {				// 지워진 노드의 자식이 있었다
			for(int i = 0; i < N; i++) {	// 전체를 다 검사하면서
				if(node[i][0] == d)			// 부모가 지워진 애들을 찾고(부모를 d로 갖는 애들을 찾는다.),
					remove(i);				// 그 자식들도 지운다.
			}
		}
	}
	
	public static void count() {
		for(int i = 0; i < N; i++) {
			// 부모가 있고, 자식이 없는 노드이면 리프 노드이다.
			if((node[i][0] != -2) && (node[i][1] == 0)) cnt++;
		}
	}
}
