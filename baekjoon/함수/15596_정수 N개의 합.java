// 15596_정수 N개의 합.java

public class Test {
    long sum(int[] a) {
        long ans = 0;
        for(int aa : a){
            ans += aa;
        }
        return ans;
    }
}
