
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16953_A에서B {
	
	static int A, B, min = 0;
	static boolean find;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		while(true) {
			if(A > B) {
				min = -1;
				break;
			}
			
			if(A == B) break;
			
			if(B%10 == 1) B /= 10;
			else if(B%2 == 0) B /= 2;
			else {
				min = -1;
				break;
			}
			
			min++;
		}
		
		if(min != -1) min++;
		System.out.print(min);
	}
	
}
