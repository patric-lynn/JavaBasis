package basic;

import java.util.Scanner;

public class basic {
    /**
     * 循环函数学习测试
     */
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
            if (k < 15) {
                continue;
            }
            //若满足条件，则跳出整体循环
            if (k > 30) {
                break Label;
            }
            System.out.println("This is " + k + " time try");
        }
        System.out.println("15到30之间输出完毕");
    }


    public static void main(String[] args) throws Exception {
        labelTest();
    }
}

