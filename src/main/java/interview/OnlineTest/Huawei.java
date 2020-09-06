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
     *
     * @param value
     * @param string
     * @return
     */
    public static String binaryOperation(int value, String string) {
        StringBuffer stringBuffer = new StringBuffer(value);
        char[] temp = string.toCharArray();
        for (int i = 0; i < value; i++) {
            if (i < value - 1 && temp[i] == '0' && temp[i + 1] == '0') {
                temp[i] = '1';
                temp[i + 1] = '0';
            } else if (i < value - 2 && temp[i] == '0' && temp[i + 1] == '1' && temp[i + 2] == '0') {
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

    public static void binaryOperationExec() {
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


    public static void findRegularExec() {
        Scanner in = new Scanner(System.in);
        int count = 0;
        String[] strings = new String[1000];
        boolean flag = false;
        while (true) {
            String tmp = in.next();
            strings[count] = tmp;
            count++;
            if (flag) {
                break;
            }
            if (tmp.length() == 1) {
                flag = true;
            }
        }
        String[] result = findRegular(strings, count);
        for (String r : result) {
            if (r != null) {
                System.out.println(r);
            }
        }
    }

    public static String[] findRegular(String[] strings, int count) {
        int length = strings.length;
        int key = Integer.parseInt(strings[count - 2]);
        String Code = getCode(strings[count - 1], key);
        String[] codeResult = new String[length - 2];
        int j = 0;
        for (int i = 0; i < count - 2; i++) {
            //System.out.println(getCode(strings[i], key));
            if (getCode(strings[i], key).contains(Code)) {
                codeResult[j] = strings[i];
                j++;
            }
        }
        return codeResult;
    }

    public static String getCode(String s, int key) {
        int length = s.length();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(String.valueOf(s.charAt(i))) < key) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        getNum(in.next());
    }


    public static String getNum(String s) {
        String[] tmp = s.split(";");
        String s1 = tmp[0];
        String s2 = tmp[1];
        int result = 0;
        int length = s1.length() > s2.length() ? s1.length() : s2.length();
        String[] c1 = s1.split(" ");
        String[] c2 = s1.split(" ");
        for (int i = 0; i < length; i++) {
            if (c1[i] != null && c2[i] != null) {
                if (c1[i] == c2[i]) {

                }
            }

        }
        return "(" + result + ",5)";
    }
}
