import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BJ_18870_좌표압축_Map {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] pos = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			pos[i] = num;
		}
		
		int[] posSort = pos.clone();
		Arrays.sort(posSort);

		// Map<key, value>
		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for(int p : posSort) {
			// 중복되지 않도록 포함되는지 확인 후 포함되지 않는 경우에만 map에 추가
			if(!map.containsKey(p)) map.put(p, idx++);
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(map.get(pos[i])).append(" ");
		}
		
		System.out.print(sb);
	}
}
