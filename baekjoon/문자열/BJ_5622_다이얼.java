package 문자열;
import java.io.*;

public class BJ_5622_다이얼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] dial = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		
		char[] input = br.readLine().toCharArray();
		
		int sum = 0;
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < dial.length; j++) {
				for(int k = 0; k < dial[j].length(); k++) {
					if(input[i] == dial[j].charAt(k)) {
						sum += j+3;
						break;
					}
				}
			}
		}
		
		System.out.println(sum);
	}
}
