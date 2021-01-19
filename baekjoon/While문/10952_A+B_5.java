// 10952_A+B_5.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        
        while(true){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            
            if(num1 + num2 == 0) break;
            
            System.out.println(num1 + num2);
        }
    }
}
