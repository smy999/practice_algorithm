// 11022_A+B_8.java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        
        int num1, num2;
        for (int i = 1; i <= cnt; i++){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            
            System.out.println("Case #" + i + ": " + num1 + " + " + num2 + " = " + (num1 + num2));
        }
    }
}
