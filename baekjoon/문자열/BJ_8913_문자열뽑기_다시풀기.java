package Sep_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_8913_문자열뽑기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			int len = str.length();
			HashMap<Integer, Character> map = new HashMap<>();
			
			int idx = 0;
			int idx2 = 0;
			map.put(idx2, str.charAt(idx++));
			
			boolean isGroup = false;
			
			while(idx < len) {
				if(map.get(idx2) == str.charAt(idx)) isGroup = true;
				else {
					if(isGroup) {
						map.remove(idx2--);
						isGroup = false;
					}
					map.put(++idx2, str.charAt(idx));
				}
				idx++;
			}
			
//			if(map.size() > 0) sb.append(0).append("\n");
			if(isGroup) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.print(sb);
	}
}
