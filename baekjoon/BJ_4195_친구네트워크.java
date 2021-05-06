import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_4195_친구네트워크 {
	
	static int maxSize;	// 배열 크기 (최대 네트워크 수 * 2)
	static int[] parent;
	static int[] friendsCnt;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int F = Integer.parseInt(br.readLine());
			
			maxSize = F*2;
			parent = new int[maxSize];
			friendsCnt = new int[maxSize];
			
			makeSet();
			
			map = new HashMap<>();
			int idx = 0;	// map에 저장할 입력 순서를 나타내는 index
	
			for(int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String p1 = st.nextToken();
				String p2 = st.nextToken();
				
				if(!map.containsKey(p1)) map.put(p1, idx++);
				if(!map.containsKey(p2)) map.put(p2, idx++);
				
				unionSet(map.get(p1), map.get(p2));
				
				sb.append(friendsCnt[findSet(map.get(p1))]).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void makeSet() {
		for(int i = 0; i < maxSize; i++) {
			parent[i] = i;	// 부모는 본인 -> 입력 받으면서 처리
			friendsCnt[i] = 1;	// 처음 관계 수는 모두 1로 초기화
		}
	}
	
	private static int findSet(int p) {
		if(p == parent[p]) return p;
		return parent[p] = findSet(parent[p]);
	}
	
	private static void unionSet(int p1, int p2) {
		// 부모 가져오기
		int root1 = findSet(p1);	
		int root2 = findSet(p2);
		
		// 부모가 같으면 이미 같은 네트워크 형성
		if(root1 == root2) return;
		
		// 부모가 다르면 네트워크 형성해주고 부모 통일
		parent[root2] = root1;
		// 네트워크 형성한 친구 수 증가
		friendsCnt[root1] += friendsCnt[root2];
	}
}
