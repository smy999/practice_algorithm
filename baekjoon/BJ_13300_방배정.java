import java.io.*;
import java.util.StringTokenizer;

public class BJ_13300_방배정 {
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input_13300.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[2][6];
		
		int gender, grade;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			gender = Integer.parseInt(st.nextToken());
			grade = Integer.parseInt(st.nextToken());
			
			students[gender][grade-1]++;
		}
		
		int rooms = 0;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				int tmp = students[i][j];
				while(tmp > 0) {
					rooms++;
					tmp -= K;
				}
			}
		}
		
		System.out.println(rooms);
	}
}
