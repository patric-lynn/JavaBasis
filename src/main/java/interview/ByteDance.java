package interview;

import java.util.Scanner;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/12 21:13
 */
public class ByteDance {
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

    public static void main(String[] args) {
        breakNumExec();
        judgeExec();
    }
}
