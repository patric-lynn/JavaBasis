package interview.OnlineTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/9/13 10:21
 */
public class MeiTuan {
    public static void decorateExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
        }
        System.out.println(decorate(value, n, m, k));
    }

    /**
     * 时间限制： 3000MS
     * 内存限制： 589824KB
     * 题目描述：
     * 小团需要购买m样装饰物。商店出售n种装饰物，按照从小到大的顺序从左到右摆了一排。对于每一个装饰物，小团都给予了一个美丽值ai。
     * <p>
     * 小团希望购买的装饰物有着相似的大小，所以他要求购买的装饰物在商店中摆放的位置是连续的一段。小团还认为，一个装饰物的美丽值不能低于k，否则会不好看。
     * <p>
     * 现在，请你计算小团有多少种不同的购买方案。
     * <p>
     * <p>
     * <p>
     * 输入描述
     * 输入第一行包含三个数n,m,k
     * <p>
     * 接下来一行n个整数ai ( 1≤ i ≤n )，空格隔开，表示商店从左到右摆放的每个装饰物的美丽值。
     * <p>
     * n , m≤100000
     * <p>
     * 1≤ai ,k≤10^9
     * <p>
     * 输出描述
     * 输出一个数，表示小团购买的方案数。
     * <p>
     * <p>
     * 样例输入
     * 8 2 5
     * 5 5 5 4 5 5 5 5
     * 样例输出
     * 5
     * <p>
     * 提示
     * 有[1,2][2,3][5,6][6,7][7,8] 共5段
     *
     * @param value
     * @param n
     * @param m
     * @param k
     * @return
     */
    public static int decorate(int[] value, int n, int m, int k) {
        int result = 0;
        for (int i = 0; i < n - m + 1; i++) {
            label:
            for (int j = i; j < i + m; j++) {
                if (value[j] < k) {
                    break label;
                }
                if (j == i + m - 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void compositionExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt(), d = in.nextInt();
        System.out.println(composition(n, k, d));
    }

    public static int A(int n, int m) {
        int result = 1;
        for (int i = m; i > 0; i--) {
            result *= n;
            n--;
        }
        return result;
    }

    public static int composition(int n, int k, int d) {
        int result = 0;
        for (int i = d; i < n - k; i++) {
            result += A(n, i);
        }
        return result;
    }


    public static void thingsExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] priority = new Integer[n];
        Integer[] must = new Integer[n];
        for (int i = 0; i < n; i++) {
            priority[i] = in.nextInt();
            must[i] = in.nextInt();
        }
        Integer[] result = things(priority, must, n);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static class Mycomparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {

            if (o1 > o2) // 默认是o1 < o2时返回-1， 一下同理
                return -1;
            if (o1 < o2)
                return 1;
            return 0;
        }
    }

    public static Integer[] things(Integer[] priority, Integer[] must, int n) {
        Integer[] result = new Integer[n];
        Comparator<Integer> c = new Mycomparator();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(must[i], i + 1);
        }
        Arrays.sort(must, c);
        for (int i = 0; i < n; i++) {
            result[i] = map.get(must[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        //decorateExec();
        //compositionExec();
        thingsExec();
    }
}
