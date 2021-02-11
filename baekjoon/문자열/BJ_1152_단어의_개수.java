package 문자열;
import java.io.*;

public class BJ_1152_단어의_개수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int size = str.length;
		
		for(int i = 0; i < str.length; i++)
			if(str[i].length() == 0) size--;
		
		System.out.print(size);
	}
}
