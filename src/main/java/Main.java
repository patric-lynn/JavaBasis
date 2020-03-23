import java.util.Scanner;

public class Main {
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

        // Scanner scanner = new Scanner(System.in);
        // int m = scanner.nextInt();
        // int n = scanner.nextInt();
        // char[][] a = null;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         a[i][j]= new Scanner(System.in).next;
        //     }
        // }

    }
}
