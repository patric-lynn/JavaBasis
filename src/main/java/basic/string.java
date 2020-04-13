package basic;

import java.util.Stack;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/24 00:43
 */
public class string {
    /**
     * 字符串逆置代码
     * 二分递归地将后面的字符和前面的字符连接起来。
     *
     * @param s
     * @return
     */
    public static String reverse1(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse1(right) + reverse1(left);
    }

    /**
     * 取得当前字符并和之前的字符append起来，相当于不断前插
     * @param s
     * @return
     */
    public static String reverse2(String s) {
        int length = s.length();
        String reverse = "";
        for (int i=0; i<length; i++)
            reverse = s.charAt(i) + reverse;
        return reverse;
    }

    /**
     * 将字符从后往前的append起来
     * @param s
     * @return
     */
    public static String reverse3(String s) {
        char[] array = s.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--) {
            reverse += array[i];
        }
        return reverse;
    }

    /**
     * 和StringBuffer()一样，都用了Java自实现的方法，使用位移来实现
     * @param s
     * @return
     */
    public static String reverse4(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * 和StringBuilder()一样，都用了Java自实现的方法，使用位移来实现
     * @param s
     * @return
     */
    public static String reverse5(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    /**
     * 二分交换，将后面的字符和前面对应的那个字符交换
     * @param s
     * @return
     */
    public static String reverse6(String s) {
        char[] array = s.toCharArray();
        int end = s.length() - 1;
        int halfLength = end / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = array[i];
            array[i] = array[end-i];
            array[end-i] = temp;
        }

        return new String(array);
    }

    /**
     * 原理是使用异或交换字符串
     * a=a^b;
     * b=b^a;
     * a=b^a;
     *
     * @param s
     * @return
     */
    public static String reverse7(String s) {
        char[] array = s.toCharArray();

        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            array[begin] = (char) (array[begin] ^ array[end]);
            array[end] = (char) (array[end] ^ array[begin]);
            array[begin] = (char) (array[end] ^ array[begin]);
            begin++;
            end--;
        }

        return new String(array);
    }

    /**
     * 基于栈先进后出的原理
     *
     * @param s
     * @return
     */
    public static String reverse8(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < array.length; i++)
            stack.push(array[i]);

        String reverse = "";
        for (int i = 0; i < array.length; i++)
            reverse += stack.pop();

        return reverse;
    }

    //字符串相等测试
    public static void stringTest1() {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
    }

    //字符串连接与更改测试
    public static void stringTest2() {
        String s = "Hello ";
        String s1 = "Hello World";

        //string的连接运算，不算重载，就是直接的字符串相加。
        int n = 5;
        for (int i = 0; i < n; i++) {
            s += "baby ";
            System.out.println(i + "个字符串已生成" + s);
        }

        // 字符串连接 concatenate以及indexof方法
        s1 += "!";
        System.out.println(s1);
        // 2. find
        System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
        System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
        // 3. get substring
        System.out.println(s1.substring(6, 11));

        //测试string的第一种更改方式
        char[] c = s.toCharArray();
        System.out.println(c);
        c[5] = ',';
        System.out.println(c + "不改变原S字符串的值");

        //测试string第二种更改方式 借助stringbuffer或者stringbuilder
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.append("happygirl");
        s = stringBuffer.toString();
        System.out.println(s);
    }

    public static void main(String[] args) {
        System.out.println(reverse1("Wang Sheng"));
        System.out.println(reverse2("Wang Sheng"));
        System.out.println(reverse3("Wang Sheng"));
        System.out.println(reverse4("Wang Sheng"));
        System.out.println(reverse5("Wang Sheng"));
        System.out.println(reverse6("Wang Sheng"));
        System.out.println(reverse7("Wang Sheng"));
        System.out.println(reverse8("Wang Sheng"));
    }
}
