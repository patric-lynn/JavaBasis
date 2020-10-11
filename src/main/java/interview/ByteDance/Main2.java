package interview.ByteDance;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created on 2020/10/11.
 *
 * @author Duo Zhang
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getMax(n, arr));
    }

    /**
     *
     * @param n
     * @param arr
     * @return
     */
    public static int getMax(int n, int[] arr) {
        int[] l = new int[n];
        int[] r = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                l[i] = -1;
            } else {
                l[i] = s.peek();
            }
            s.push(i);
        }
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                r[i] = n;
            } else {
                r[i] = s.peek();
            }
            s.push(i);
        }
        int are = 0;
        for (int i = 0; i < n; i++) {
            int temp = (r[i] - l[i] - 1) * arr[i];
            are = Math.max(are, temp);
        }
        return are;
    }
}
