package 문자열;

import java.io.*;

public class BJ_2941_크로아티아_알파벳 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] croatia = br.readLine().toCharArray();
		
		int size = croatia.length;
		for(int i = 1; i < croatia.length; i++) {
			if(croatia[i] == '=') {
				if( i-2 >= 0 && croatia[i-2] == 'd' && croatia[i-1] == 'z') size-=2;
				else size--;
			}
			else if(croatia[i] == '-') {
				size--;
			}
			else if(croatia[i] == 'j') {
				if(croatia[i-1] == 'l' || croatia[i-1] == 'n') size --;
			}
		}
		
		System.out.println(size);
	}
}
