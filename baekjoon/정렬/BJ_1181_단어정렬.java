package 정렬;

import java.io.*;
import java.util.Arrays;

public class BJ_1181_단어정렬 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str = new String[N];
		
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		Arrays.sort(str);
		
		Arrays.sort(str, (s1, s2) -> {
			return s1.length() - s2.length();
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(str[0] + "\n");
		for(int i = 1; i < N; i++) {
			if(str[i-1].equals(str[i])) continue;
			sb.append(str[i] + "\n");
		}
		
		System.out.print(sb);
	}
}
