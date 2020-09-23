package interview.OnlineTest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/29 14:47
 */
public class ZhaoshangBank {
    public static void cost() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int[] length = null;
            int[] weight = null;
            for (int j = 0; j < m; j++) {
                length[j] = scanner.nextInt();
            }
            for (int k = 0; k < m; k++) {
                weight[k] = scanner.nextInt();
            }
            if (length[i] > length[i - 1] && weight[i] > weight[i - 1]) {
                continue;
            } else {
                result[i]++;
            }
        }
        for (int i : result) {
            System.out.println(result[i]);
        }
    }




    /**
     * 题目描述
     * 在衣柜抽屉中杂乱无章地放着种不同颜色的袜子，其中第种颜色的袜子有a_i只。小招喵现在正着急去参加一场宴会，
     * 但是小招喵是一个色盲，所以无法分辨自己将要穿的袜子是不是同一颜色的，因此他随手抓了一把袜子，打算带到牛牛家让牛牛帮忙。
     * 现在的问题是，最少要从抽屉中取出多少只袜子才能保证其中一定有两只可以配成颜色相同的一双？
     * 输入描述:
     * 第一行一个数字表示测试数据的组数。
     * 对于每组数据，第一行数字表示袜子的颜色种数。
     * 第二行有个数字，第个数字a_i表示第种颜色的袜子有a_i个。
     * 输出描述:
     * 对于每组数据，输出一行一个数字表示答案。若无解输出 -1。
     * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
     * 输入
     * 2
     * 2
     * 2 2
     * 3
     * 0 0 0
     * 输出
     * 3
     * -1
     */
    public static void wazi() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] length = new int[n];
            int flag = 0;
            for (int j = 0; j < n; j++) {
                length[j] = scanner.nextInt();
                if (length[j] == 0) {
                    flag++;
                }
                if (j == n - 1 && flag == n) {
                    result[i] = 0;
                } else if (j == n - 1 && flag != n) {
                    result[i] = n + 1 - flag;
                }
            }
        }
        for (int i : result) {
            System.out.println(i);
        }
    }


    /**
     * 输入n组数，求每组数能够构成正方形和长方形的最大个数(m, n)，其中以构成正方形更多为优先目标
     * 如：3 6 3 6 9 9 6 6
     * 构成：1 1
     */
    public static void rectangularNumExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int[] value = new int[num];
            for (int j = 0; j < num; j++) {
                value[j] = in.nextInt();
            }
            result[i][0] = rectangularNum(num, value)[0];
            result[i][1] = rectangularNum(num, value)[1];
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    public static int[] rectangularNum(int n, int[] value) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(value[i], map.getOrDefault(value[i], 0) + 1);
        }
        int zheng = 0, chang = 0, chang_tmp = 0;
        for (Integer len : map.keySet()) {
            int nums = map.get(len);
            zheng += nums / 4;
            nums = nums % 4;
            if (nums >= 2) {
                chang_tmp++;
            }
        }
        chang = chang_tmp / 2;
        result[0] = zheng;
        result[1] = chang;
        return result;
    }

    /**
     * 奇数偶数对数
     */
    public static void getAnsExec() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(getAns(n, nums));
        }
    }

    public static int getAns(int n, int[] nums) {
        int jishu = 0;
        int oushu = 0;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] % 2 != i % 2) {
                if (i % 2 == 0) {
                    oushu++;
                } else {
                    jishu++;
                }
            }
        }
        if (jishu == 0 && oushu == 0) {
            return 0;
        }
        if (jishu == oushu) {
            return jishu;
        }
        return -1;
    }

    public static void main(String[] args) {
        cost();
        rectangularNumExec();
        getAnsExec();
        wazi();
    }
}
