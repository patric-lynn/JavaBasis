package interview.ByteDance;

import java.util.Scanner;

/**
 * Created on 2020/10/11.
 *
 * @author Duo Zhang
 */
public class Main1 {
    public static void cakeExec() {
        while(true){
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(cake(n, m));
        }
    }

    public static int cake(int a, int b) {
        if (a <= 1 && b <= 1) {
            return 0;
        }
        if (a % 2 == 0) {
            if(b==1) {
                return 1;
            }
            return (int) Math.pow(cake(a/2 , b),a/2);
        } else if(b % 2 == 0){
            if(a==1) {
                return 1;
            }
            return a * b/2 + a;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        cakeExec();
    }
}
