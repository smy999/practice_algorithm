package Jan_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class BJ_2693_N번째큰수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			// 자료구조: ArrayList
			ArrayList<Integer> list = new ArrayList<>();
			
			// 입력
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreElements()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			// 정렬
			Collections.sort(list);
			
			sb.append(list.get(7)).append("\n");
		}
		
		System.out.print(sb);
	}
}
