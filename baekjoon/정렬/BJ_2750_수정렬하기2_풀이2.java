package 정렬;

import java.io.*;
import java.util.*;

// 시간초과 > System.out에서 BufferedWriter로 변경

public class BJ_2750_수정렬하기2_풀이2 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			al.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(al);
		
		for(int i = 0; i < N; i++)
			bw.write(al.get(i) + "\n");
		
		br.close();
		bw.close();
	}
}
