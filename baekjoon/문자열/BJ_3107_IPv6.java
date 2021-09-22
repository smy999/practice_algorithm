package Sep_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3107_IPv6 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		int len = input.length();
		String[] ip = input.split("::");
		
		if(ip.length == 1) {
			StringTokenizer st1 = new StringTokenizer(ip[0], ":");
			
			int zeroCnt = 8 - st1.countTokens();

			String ip1 = "";
			String zero = "";
			
			while(st1.hasMoreTokens()) {
				String temp = (String)st1.nextToken();
				int tempLen = temp.length();
				for(int i = 0; i < 4-tempLen; i++) ip1 += "0";
				ip1 += temp + ":";
			}
			
			for(int i = 0; i < zeroCnt; i++) zero += "0000:";
			
			if(input.charAt(0) == ':' && input.charAt(1) == ':') sb.append(zero).append(ip1);
			else if(input.charAt(len-1) == ':' && input.charAt(len-2) == ':') sb.append(ip1).append(zero);
			else sb.append(ip1);
			
		} else {			
			StringTokenizer st1 = new StringTokenizer(ip[0], ":");
			StringTokenizer st2 = new StringTokenizer(ip[1], ":");
			
			int zeroCnt = 8 - st1.countTokens() - st2.countTokens();
			
			String ip1 = "";
			String ip2 = "";
			String zero = "";
			
			while(st1.hasMoreTokens()) {
				String temp = st1.nextToken().toString();
				int tempLen = temp.length();
				for(int i = 0; i < 4-tempLen; i++) ip1 += "0";
				ip1 += temp + ":";
			}
			
			for(int i = 0; i < zeroCnt; i++) zero += "0000:";
			
			while(st2.hasMoreTokens()) {
				String temp = st2.nextToken().toString();
				int tempLen = temp.length();
				for(int i = 0; i < 4-tempLen; i++) ip2 += "0";
				ip2 += temp + ":";
			}
			
			sb.append(ip1).append(zero).append(ip2);
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}

}
