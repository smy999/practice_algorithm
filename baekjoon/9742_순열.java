package workshop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_9742 {
	static int COUNT, order, size;
	static char[] input; 
	static String str;
	static char[] tgt;
	static boolean[] select;
	static boolean hasP;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			sb.setLength(0);
			COUNT = 0;
			hasP = false;
			
			str = br.readLine();
			if(str == null) break;
			
			
			StringTokenizer st = new StringTokenizer(str);
			
			input = st.nextToken().toCharArray();
			order = Integer.parseInt(st.nextToken());
			
			size = input.length;
			tgt = new char[size];
			select = new boolean[size];
			
			perm(0);

			if(!hasP) sb.append(str).append(" = ").append("No permutation");
			System.out.println(sb);
		}
		
		
		
	}
	
	private static void perm(int tgtIdx) {
		// 기저조건
		if(tgtIdx == size) {
			COUNT++;
			// System.out.println(Arrays.toString(tgt));
			if(COUNT == order) {
				sb.append(str).append(" = ").append(tgt);
				hasP = true;
			}
			return;
		}
		
		for(int i = 0; i < size; i++) {
			if(select[i]) continue;
			
			tgt[tgtIdx] = input[i];
			select[i] = true;
			perm(tgtIdx+1);
			select[i] = false;	
		}
		
	}
}
