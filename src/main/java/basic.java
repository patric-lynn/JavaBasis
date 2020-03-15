import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class basic {
    //循环函数测试 2020-3-1
    public static void labelTest() {
        //流式输入对象
        Scanner in = new Scanner(System.in);
        //流式输出
        System.out.print("Please input the number: ");
        //获取输入的数值
        int i = in.nextInt();
        //带标签的流程中断控制
        int k = 0;
        Label:
        for (int n = i; n != 100; n += 1) {
            k += 1;
            //若满足条件，则跳过本次循环
            if (k < 5) continue;
            System.out.println("This is " + k + " time try");
            //若满足条件，则跳出整体循环
            if (k > 30) break Label;
        }
    }

    //排序函数与堆栈的测试 2020-3-2
    public static void Sort() {
        int[] a = {5, 7, 2, 6, 1, 9, 3, 4, 8, 0};
        Arrays.sort(a);
        Stack<Integer> stack = new Stack<Integer>();
        for (int j : a) {
            System.out.println(a[j]);
        }
    }

    //测试数组 2020-3-3
    public static void Array() {
        int[] a = {1, 2, 3};
        int[] bo = a;
        System.out.println(a.length + bo.length);
    }

    //字符串测试
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
            System.out.println(i + "个字符串已生成");
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
        System.out.println(c);

        //测试string第二种更改方式 借助stringbuffer或者stringbuilder
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.append("happygirl");
        s = stringBuffer.toString();
        System.out.println(s);
    }

    //字符串替换测试
    public static String replace(StringBuffer str) {
        StringBuffer str1 = new StringBuffer();
//        String a = null;
//        StringBuilder builder = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                str1.append("%20");
            } else { //注意此处必须是二选一的形式!!!!!!!!!!!!!!!!!!!!!!!如果没有else子句，则空格也会被加上!!!!!!!!!!!
                str1.append(c);
            }
        }
        return str1.toString();
//        return str.toString().replace(" ", "%20");
    }


    //ArrayList测试
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode li = listNode;
        while (li != null) {
            list.add(0, li.val);
            li = li.next;
        }
        return list;
    }

    //文件处理测试
    public static void fileTest() throws IOException {
        File file = new File("fileTest.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.print("happy you");
        //先输出内容再输出一个回车
        printWriter.println("bcde");
        printWriter.close();
    }

    public static void main(String[] args) throws Exception {

//        //循环函数测试
//        labelTest();

//        //数组排序实验
//        Sort();

//        //数组长度测试
//        array(a);

//        //字符串测试
//        stringTest1();

//        //字符串测试
//        stringTest2();

        // replace测试
//        StringBuffer stringBuffer = new StringBuffer("wo men shi zhong guo ren");
//        System.out.println(replace(stringBuffer));

//        //文件测试
//        fileTest();

    }
}

