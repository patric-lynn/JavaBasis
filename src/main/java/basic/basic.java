package basic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class basic {
    //循环函数学习测试 2020-3-1
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




    //文件处理测试
    public static void fileTest() throws IOException {
        File file = new File("fileTest.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.print("happy you");
        //先输出内容再输出一个回车
        printWriter.println("bcde");
        printWriter.close();
    }

    public static int transfer(String str) {
        char[] c = str.toCharArray();
        int num = 0;
        int num1= Integer.parseInt(str);
        if (c[0] == '-') {
            for (int i = 1; i < c.length; i++) {
                num += c[i] * Math.exp(c.length - i);
            }
            num = -1 * num;
        } else {
            for (int i = 1; i < c.length; i++) {
                num += c[i] * (c.length - i);
            }
        }
        return num;
    }
    public static void main(String[] args) throws Exception {

        //循环函数测试
        labelTest();


        //文件测试
        fileTest();
        String a = "-358";
        System.out.println(transfer(a));
    }
}

