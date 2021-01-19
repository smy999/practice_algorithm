// 10950_A+B_3.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int cnt, num1, num2;
        
        Scanner sc = new Scanner(System.in);
        cnt = sc.nextInt();
        
        for(int i = 0; i < cnt; i++){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            
            System.out.println(num1+num2);
        }
    }
}
