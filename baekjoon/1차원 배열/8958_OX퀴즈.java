// 8958_OX퀴즈.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt; 
        int result;
        String str[] = new String[N];
        
        for(int i = 0; i < N; i++){
            str[i] = sc.next();
        }
        
        for(int i = 0; i < N; i++){
            cnt = 0;
            result = 0;
            
            for(int j = 0; j < str[i].length(); j++){
                if(str[i].charAt(j) == 'O') cnt++;
                else cnt = 0;
                
                result += cnt;
            }
            
            System.out.println(result);
        }
        sc.close();
    }
}
