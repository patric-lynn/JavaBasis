package interview.OnlineTest;

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


    public static void main(String[] args) {
        wazi();
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
}
