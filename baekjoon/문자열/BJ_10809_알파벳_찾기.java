package 문자열;
import java.io.*;

public class BJ_10809_알파벳_찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 소문자 아스키코드 97~122
		int[] alphabet = new int[122-96];
		
		for(int i = 0; i < 122-96; i++)
			alphabet[i] = -1;
		
		char[] input = br.readLine().toCharArray();
		
		for(int i = 0; i < input.length; i++) {
			if(alphabet[input[i] - 97] != -1) continue;
			alphabet[input[i] - 97] = i;
		}
		
		for(int i = 0; i < 122-96; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}
}
