package 문자열;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BJ_2908_상수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int flag = 1;
		for(int i = 10; i <= 100; i*=10) {
			
			if(num1%i == num2%i) continue;
			
			if(num1%i < num2%i) {
				flag = 2;
				break;
			} else {
				break;
			}
		}
		
		int result;
		if(flag == 1) result = num1;
		else result = num2;
		
		for(int i = result; i > 0; i/=10) {
			System.out.print(i%10);
		}
	}
}
