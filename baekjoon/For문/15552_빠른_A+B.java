// 15552_빠른_A+B.java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num1, num2;
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            
            bw.write((num1+num2) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
