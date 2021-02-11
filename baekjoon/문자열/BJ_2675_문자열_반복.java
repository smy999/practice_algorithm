package 문자열;
import java.io.*;
import java.util.*;

public class BJ_2675_문자열_반복 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] c = st.nextToken().toCharArray();
			for(int i = 0; i < c.length; i++) {
				for(int j = 0 ; j < N; j++) {
					System.out.print(c[i]);
				}
			}
			System.out.println();
		}
	}
}
