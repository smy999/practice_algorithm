import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_9177_단어섞기 {
	
	static int fLen, sLen, tLen;
	static boolean yes;
	static char[] first, second, third;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= N; t++) {
			st = new StringTokenizer(br.readLine());
			
			// 입력 배열로 받기
			first = st.nextToken().toCharArray();
			second = st.nextToken().toCharArray();
			third = st.nextToken().toCharArray();

			// 배열 길이 저장
			fLen = first.length;
			sLen = second.length;
			tLen = third.length;
			
			// 포함 관계를 검사하지 않으면 시간초과
			Set<Character> set = new HashSet<>();
			int size = fLen > sLen ? fLen : sLen;
			for(int i = 0; i < size; i++) {
				if(i < fLen) set.add(first[i]);
				if(i < sLen) set.add(second[i]);
			}
			
			yes = true;
			for(int i = 0; i < tLen; i++) {
				if(!set.contains(third[i])) {
					yes = false;
					break;
				}
			}
			if(!yes) {
				sb.append("Data set ").append(t).append(": no\n");
				sb.append("\n");
				continue;
			}
			
			// dfs로 검사
			yes = false;
			dfs(0, 0, 0);
			
			sb.append("Data set ").append(t).append(": ");
			if(yes) sb.append("yes\n");
			else sb.append("no\n");
		}
		
		System.out.print(sb);
		br.close();
	}
	
	private static void dfs(int idx, int fIdx, int sIdx) {
		if(yes) return;
		
		// 문자열을 만들 수 있다.
		if(idx == tLen) {
			yes = true;
			return;
		}
		
		// 각 배열의 범위를 벗어나지 않고  해당 위치의 문자가 같다면 다음 검사
		if(fLen > fIdx && first[fIdx] == third[idx]) dfs(idx+1, fIdx+1, sIdx);
		if(sLen > sIdx && second[sIdx] == third[idx]) dfs(idx+1, fIdx, sIdx+1);	// else if 가 아닌 if야!!
	}
	
}
