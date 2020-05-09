package interview.alibaba;

import java.util.Scanner;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/27 18:56
 */
public class alibaba {
    static int count = 0;

    public static int countDuiwu(int n) {
        if (n == 0) return 0;
        for (int i = 1; i <= n; i++) {
            count += C(n, i)*i;
        }
        count = count % 1000000007;
        return count;
    }

    public static int A(int n, int m) {
        int result = 1;
        for (int i = m; i > 0; i--) {
            result *= n;
            n--;
        }
        return result;
    }

    public static int C(int n, int m) {
        int numerator = A(n, m);
        int denominator = A(m, m);
        return numerator / denominator;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countDuiwu(n));
    }
}

