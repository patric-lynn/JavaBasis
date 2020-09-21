package interview.OnlineTest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/12 21:13
 */
public class ByteDance {
    /**
     * 笔试题目一：切木块
     *
     * @param nums
     * @return
     */
    public static int breakNum(int[] nums) {
        int ans = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) continue;
            int t = (nums[i] - 1) / nums[i + 1];
            ans += t;
            nums[i] /= (t + 1);
        }
        return ans;
    }

    public static void breakNumExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(breakNum(nums));
    }

    /**
     * 笔试题目二：判断是否合理
     *
     * @param n
     * @param num1
     * @param nums2
     * @return
     */
    public static boolean judge(int n, int[] num1, int[] nums2) {
        int delta = 0;
        for (int i = 0; i < n; i++) {
            if (delta == 0 && (num1[i] - nums2[i]) == 0) {
                continue;
            } else if (delta == 0 && (num1[i] - nums2[i]) != delta) {
                delta = num1[i] - nums2[i];
            } else if (delta != 0 && (num1[i] - nums2[i]) == 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void judgeExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] booleans = new boolean[n];
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int[] nums1 = new int[m];
            int[] nums2 = new int[m];
            for (int j = 0; j < m; j++) {
                nums1[j] = in.nextInt();
            }
            for (int k = 0; k < m; k++) {
                nums2[k] = in.nextInt();
            }
            booleans[i] = judge(m, nums1, nums2);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(booleans[i]);
        }
    }


    /**
     * 获取合适的数字，已完成
     */
    public static int getNum(int n) {
        if (n == 0) {
            return 0;
        }
        return n * (n - 1) + 1;
    }

    public static void getNumExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getNum(n));
    }

    /**
     * 解码语句，未完成
     *
     * @param strings
     * @return
     */
    public static String decode(String[] strings) {
        StringBuffer result = new StringBuffer();
        String[][] strings1 = new String[strings.length][20];
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            strings1[i] = strings[i].split("");
            for (int j = 0; j < strings[i].length(); j++) {
                result.append(strings1[i][j]);
            }
        }
        return result.toString();
    }

    public static void decodeExec() {
        Scanner in = new Scanner(System.in);
        String[] result = new String[100];
        int j = 0;
        while (true) {
            int n = in.nextInt();
            String[] strings = new String[80];
            if (n == 0) {
                break;
            }
            for (int i = 0; i <= n; i++) {
                strings[i] = in.next();
            }
            result[j] = decode(strings);
            j++;
        }
        for (String s : result) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }


    /**
     * 笔试三：实现一个小型计算器
     */
    public static void Calculator() {
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

    /**
     * KMP求最小循环子串
     */
    public static void loopExec() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(loop(s));
    }

    public static String loop(String s) {
        String str = s + s;
        String result = s;
        boolean flag = str.substring(1, str.length() - 1).contains(s);
        if (!flag) {
            return s;
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.length() % i == 0) {
                    String tmp = s.substring(0, i);
                    for (int j = i; j + i <= s.length(); j += i) {
                        if (!tmp.equals(s.substring(j, j + i))) {
                            break;
                        }
                        if (j + i == s.length()) {
                            result = tmp;
                            break;
                        }
                    }
                }
                if (result != s) {
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        breakNumExec();
        judgeExec();
        getNumExec();
        decodeExec();
        loopExec();
        Calculator();
    }
}
