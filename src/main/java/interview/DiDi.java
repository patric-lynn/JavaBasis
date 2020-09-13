package interview;

import java.util.Scanner;

/**
 * Description
 * 1.密文
 * 输入描述
 * 单组输入。
 * 每组测试数据的输入占两行，其中第一行包含一个正整数n，表示分割时每个子字符串的长度，第二行为密文字符串S。 （密文字符串S的长度<=1000，n<=100）
 * 密文可能包含英文大小写字母、数字、空格和英文标点符号。
 * 输出描述
 * 每组测试数据的输出占一行，表示破解密文后得到的明文。
 * 样例输入
 * 2
 * gogogoout
 * 样例输出
 * ogogoguot
 *
 * 2.造桥成本
 * 输入描述
 * 多组输入，第1行输入一个正整数T表示输入数据的组数。
 * 对于每一组输入数据：输入m+1行。
 * 第1行包含三个正整数，分别表示n、m和k，n≤100，m≤1000，k≤10000，三个数字之间用空格隔开。
 * 接下来m行表示m条小岛之间的造桥成本数据，每一行包含三个正整数，分别表示两个小岛的编号（从1开始）和这两个小岛之间的造桥成本（单位：万）。
 * 输出描述
 * 针对每一组输入数据，如果能够完成造桥工程输出“Yes”，否则输出“No”。
 *
 *
 * 样例输入
 * 2
 * 3 3 400
 * 1 2 200
 * 1 3 300
 * 2 3 500
 * 3 3 400
 * 1 2 500
 * 1 3 600
 * 2 3 700
 * 样例输出
 * Yes
 * No
 * @author Lynn-zd
 * @date Created on 2020/9/13 19:48
 */
public class DiDi {
    public static void decodeExec() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        System.out.println(decode(n, s));
    }

    public static String decode(int n, String s) {
        StringBuffer result = new StringBuffer();
        int k = s.length() / n;
        int y = s.length() % n;
        for (int i = 0; i < k + 1; i++) {
            if (i < k) {
                for (int j = n - 1; j >= 0; j--) {
                    result.append(s.charAt(j + i * n));
                }
            } else {
                for (int j = y - 1; j >= 0; j--) {
                    result.append(s.charAt(j + i * n));
                }
            }
        }
        return result.toString();
    }

    public static void bridgeExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] value = new int[n][3];
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            value[i][0] = in.nextInt();
            value[i][1] = in.nextInt();
            value[i][2] = in.nextInt();
            int m = value[i][2];
            int[][] matrix = new int[m][3];
            for (int j = 0; j < m; j++) {

            }
            result[i] = bridge(m, matrix);
        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String bridge(int m, int[][] matrix){
        StringBuffer result = new StringBuffer();

        result.append("Yes");
        return result.toString();
    }

    public static void main(String[] args) {
        decodeExec();
    }
}
