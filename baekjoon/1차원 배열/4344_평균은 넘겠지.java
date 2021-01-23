// 4344_평균은 넘겠지.java

import java.util.Scanner;

public class Main{
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int T = sc.nextInt();
         int N, cnt;
         double avg, avg2;
         int score[];
         
         for(int t = 0; t < T; t++){
             
             N = sc.nextInt();
             score = new int[N];
             
             avg = 0;
             
             for(int n = 0; n < N; n++){
                 score[n] = sc.nextInt();
                 avg += score[n];
             }
             
             avg = avg/N;
             
             cnt = 0;
             for(int n = 0; n < N; n++){
                 if(score[n] > avg){
                    cnt++;
                 }
             }
             System.out.printf("%.3f%%\n", Math.round(((double)cnt/N*100)*1000)/1000.0);
         }
     }
}
