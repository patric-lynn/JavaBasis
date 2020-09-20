import java.util.Scanner;

public class Main {
    public static void decode() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long p = 1000000007;
        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            String op = in.next();
            switch (op) {
                case "+":
                    result[i] = (a + b) % p;
                    break;
                case "-":
                    result[i] = (a - b) % p;
                    break;
                case "*":
                    result[i] = ((a % p) * (b % p)) % p;
                    break;
                case "^":
                    long tmp = (long) (Math.pow(a, b));
                    result[i] = tmp % p;
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        decode();
    }
}









