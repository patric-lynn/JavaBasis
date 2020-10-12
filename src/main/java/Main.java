import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s;
        int[] nums = new int[n];
        s = in.next().split("");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println();
    }
}
