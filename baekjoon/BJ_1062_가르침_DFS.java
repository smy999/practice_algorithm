package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1062_가르침_DFS {

	static int N, K, max = 0;
	static String[] word;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 기본적으로 배워야하는 알파의 개수가 5이기 때문에 5개 이하면 모든 단어를 읽을 수 없다.
		if(K < 5) {
			System.out.print(0);
			return;
		} // 26가지의 알파벳을 배울 수 있으면 모든 알파벳을 배워 모든 단어를 읽을 수 있다.
		else if(K == 26) {
			System.out.print(N);
			return;
		} // 위 두가지 경우가 아니면 모든 경우를 계산하여 읽을 수 있는 단어의 개수를 구한다.
		else {
			// 단어 입력
			word = new String[N];
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				word[i] = input.substring(4, input.length()-4);
			}
			
			// 방문배열을 통해 배운 글자 체크
			visited = new boolean[26];
			visited['a'-'a'] = visited['n'-'a'] = visited['t'-'a']
					= visited['i'-'a'] = visited['c'-'a'] = true;
			
			// 기본적으로 배워야하는 알파벳의 수를 K에서 뺀 후 탐색을 수행한다.
			K -= 5;
			dfs(0, 0);
			
			System.out.print(max);
		}
	}
	
	public static void dfs(int idx, int k) {
		// 배운 알파벳의 수가 K와 같으면 더이상 배울 수 없다.
		if(k == K) {
			int cnt = 0;				// 읽을 수 있는 단어의 개수
			for(int i = 0; i < N; i++) {// 해당 단어가 배운 알파벳으로 읽을 수 있는 단어인지 판단한다.
				if(read(i)) cnt++;
			}
			max = Math.max(max, cnt);	// 각 경우마다 읽을 수 있는 단어의 최대값을 갱신한다.
			return;
		}
		
		for(int i = idx; i < 26; i++) {	// 방문 배열을 통해 K개의 단어를 배운다.
			if(visited[i]) continue;
			visited[i] = true;			// 배운 단어를 체크하고
			dfs(i+1, k+1);				// 다음 단어를 배우기 위해 다시 하수 호출
			visited[i] = false;			// 배우기 전 상태로 되돌아가기
		}
	}
	
	public static boolean read(int idx) {
		// idx번째 단어를 배운 알파벳으로 읽을 수 있는지 판단하고
		// 읽을 수 있으면 true, 아니면 false
		for(int i = 0; i < word[idx].length(); i++) {
			if(!visited[word[idx].charAt(i) - 'a']) return false;
		}
		return true;
	}
}
