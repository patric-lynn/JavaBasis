package jianzhioffer;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description
 * 面试题10- I. 斐波那契数列: 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。[递推法]
 * 面试题10- II. 青蛙跳台阶问题: 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。[递推法或动态规划]
 * 面试题15. 二进制中1的个数: 输入一个整数，输出该数二进制表示中 1 的个数。[逻辑与和位移]
 * 面试题16. 数值的整数次方: 不得使用库函数，同时不需要考虑大数问题.[分两种情况讨论]
 * 面试题17. 打印从1到最大的n位数: 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。[指数函数]
 * 面试题40. 最小的k个数: 输入整数数组 arr ，找出其中最小的 k 个数。[最大堆]
 * 面试题43. 1～n整数中1出现的次数: 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。[按位计算]
 * 面试题49. 丑数: 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。[动态规划]
 *
 * @author Lynn-zd
 * @date Created on 2020/4/14 01:13
 */
public class NumberRelatedQuestions {
    /**
     * 面试题10- I. 斐波那契数列
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 示例 1：
     * 输入：n = 2
     * 输出：1
     *
     * 示例 2：
     * 输入：n = 5
     * 输出：5
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        long sum = 0;
        long a = 0;
        long b = 1;
        if (n < 2) {
            return n;
        } else {
            for (int i = 2; i <= n; i++) {
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return (int) sum;
        }
    }

    /**
     * 面试题10- II. 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     *
     * 示例 2：
     * 输入：n = 7
     * 输出：21
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    /**
     * 面试题15. 二进制中1的个数
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
     * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     *
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * 方法一：逐位判断
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1; // Java 中无符号右移为 ">>>"
        }
        return res;
    }

    //n与n-1与操作
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }


    /**
     * 面试题16. 数值的整数次方
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题
     * 示例 1:
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }


    /**
     * 面试题17. 打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     *
     * 示例 1:
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10, n);
        int[] arr = new int[num - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }


    /**
     * 剑指 Offer 40. 最小的k个数
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * 示例 1：
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     *
     * 大根堆(前 K 小) / 小根堆（前 K 大),Java中有现成的 PriorityQueue，实现起来最简单：O(NlogK)O(NlogK)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num: arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }
        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }


    /**
     * 面试题43. 1～n整数中1出现的次数
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     * 示例 1：
     *
     * 输入：n = 12
     * 输出：5
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        //求每个位的数字所用
        int index = 1;
        //记录1的个数
        int count = 0;
        int high = n, cur = 0, low = 0;
        //由于high = n /(index*10) 中index *10 很容易越位
        //特修改如下
        while (high > 0) {
            high /= 10;
            cur = (n / index) % 10;
            low = n - (n / index) * index;
            //以下是计算的公式
            if (cur == 0) count += high * index;
            if (cur == 1) count += high * index + low + 1;
            if (cur > 1) count += (high + 1) * index;
            index *= 10;
        }
        return count;
    }


    /**
     * 面试题49. 丑数
     * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * 示例:
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
