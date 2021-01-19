// 10951_A+B_4.java

// solv #1
/* 
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        
        while(sc.hasNextInt()){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            
            System.out.println(num1 + num2);
        }
    }
}
*/

// solv #2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        int num1, num2;
        
        while((input = br.readLine()) != null){
            st = new StringTokenizer(input);
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            
            System.out.println(num1 + num2);
        }
    }
}
