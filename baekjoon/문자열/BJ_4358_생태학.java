package Sep_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ_4358_생태학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> treeMap = new HashMap<>();
		
		int totalCnt = 0;
		
		while(true) {
			String str = br.readLine();
			if(str == null || str.length() == 0) break;
			// getOrDefault(): 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.
			treeMap.put(str, treeMap.getOrDefault(str, 0) + 1);
			totalCnt++;
		}
		
		// 키값을 배열로 받아온다.
		Object[] treeArr = treeMap.keySet().toArray();
		Arrays.sort(treeArr);
		
		for(Object tree : treeArr) {
			int value = treeMap.get((String)tree);
			double percent = ((double)value / (double)totalCnt) * 100;
			sb.append(tree).append(" ").append(String.format("%.4f", percent)).append("\n");
		}
		
		System.out.print(sb);
	}
}
