// 1110_더하기 사이클.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int tmp = N;
        int cnt = 0;
        while(true){
            if(tmp < 10){
                tmp = (tmp * 10) + tmp; 
            }else{
                tmp = ((tmp % 10)*10) + ((tmp % 10) + (tmp / 10))%10;
            }
            
            cnt++;
            
            if(tmp == N){
                System.out.println(cnt);
                break;
            }
        }
    }
}
