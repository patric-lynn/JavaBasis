package interview.OnlineTest;

import java.util.Scanner;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/8 20:25
 */
public class Huawei {
    /**
     * 笔试题目一：
     * 二叉操作
     * @param value
     * @param string
     * @return
     */
    public static String binaryOperation(int value, String string) {
        StringBuffer stringBuffer = new StringBuffer(value);
        char[] temp = string.toCharArray();
        for (int i = 0; i < value; i++) {
            if (i<value-1 && temp[i] == '0' && temp[i + 1] == '0') {
                temp[i] = '1';
                temp[i + 1] = '0';
            } else if (i<value-2 && temp[i] == '0' && temp[i + 1] == '1' && temp[i + 2] == '0') {
                temp[i] = '1';
                temp[i + 1] = '0';
                temp[i + 2] = '1';
            } else {
                continue;
            }
        }
        int i = 0;
        while (i < value) {
            stringBuffer.append(temp[i++]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int group = in.nextInt();
        int[] count = new int[group];
        String[] strings = new String[group];
        for (int i = 0; i < group; i++) {
            count[i] = in.nextInt();
            strings[i] = in.next();
        }
        for (int i = 0; i < group; i++) {
            strings[i] = binaryOperation(count[i], strings[i]);
            System.out.println(strings[i]);
        }
    }
}
