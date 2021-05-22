import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_6198_옥상정원꾸미기 {

	static int N;
	static long ans;
	static Stack<Long> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			Long num = Long.parseLong(br.readLine());
			
			// stack을 아래서부터 위로 내림차순을 유지한다.
			while(!stack.isEmpty()) {
				if(stack.peek() <= num) stack.pop();
				else break;
			}
			
			// 내림차순이 유지될 때마다 stack의 크기만큼의 개수가 증가한다.
			ans += stack.size();
			stack.push(num);
		}
		System.out.print(ans);
	}
}
