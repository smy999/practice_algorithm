import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493 {

	static int N, top;
	static Stack<int[]> stack = new Stack<int[]>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			
			top = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[0] > top) {
					sb.append(stack.peek()[1]).append(" ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			
			stack.push(new int[] {top, i});

		}
		
		System.out.println(sb.substring(0, sb.length()-1));
	}
}
