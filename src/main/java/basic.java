import java.util.Arrays;
import java.util.Scanner;

public class basic {

    public static void main(String[] args) {
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

        //数组排序实验
        int[] a ={5,7,2,6,1,9,3,4,8,0};
        Sort(a);
        for (int j:a) {
            System.out.print(a[j]);
        }
        return;
    }


    //排序函数定义
    public static void Sort(int[] a){
        Arrays.sort(a);
    }

}

