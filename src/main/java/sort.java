import java.time.Clock;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/16 17:12
 */
public class sort {
    /**
     * 获取一个打乱的数组
     * @param arr
     */
    private static int[] getRandomArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(arr.length);
        }
        return arr;
    }


    /**
     * arrays排序函数与堆栈的测试 2020-3-2
     */
    public static void arraysort() {
        int[] a = {5, 7, 2, 6, 1, 9, 3, 4, 8, 0};
        Arrays.sort(a);
        Stack<Integer> stack = new Stack<Integer>();
        for (int j : a) {
            System.out.println(a[j]);
        }
    }


    /**
     * 冒泡排序基本版
     * 两两向后交换
     * @param arr
     */
    public static void  maopaosort(int[] arr){
        for (int i = 1; i < arr.length; i++) {  //第一层for循环,用来控制冒泡的次数
            for (int j = 0; j < arr.length-1; j++) { //第二层for循环,用来控制冒泡一层层到最后
                //如果前一个数比后一个数大,两者调换 ,意味着泡泡向上走了一层
                if (arr[j] > arr[j+1] ){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 升级版冒泡排序
     * 加入一个布尔变量,如果内循环没有交换值,说明已经排序完成,提前终止
     * @param arr
     */
    public static void maopaosortPlus(int[] arr){
        if(arr != null && arr.length > 1){
            for(int i = 0; i < arr.length - 1; i++){
                // 初始化一个布尔值，每次循环时重新赋值
                boolean flag = true;
                for(int j = 0; j < arr.length - i - 1 ; j++){
                    if(arr[j] > arr[j+1]){
                        // 调换
                        int temp;
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        // 改变flag
                        flag = false;
                    }
                }
                if(flag){
                    break;
                }
            }
        }
    }

    /**
     * 快速排序
     * 三个参数，空返回值
     *
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort(int[] array, int start ,int end){
        int a = start;
        int b = end;
        if(a >= b) return;
        int x = array[a];
        while(a < b ){
            while (a < b && array[b]>=x){
                b--;
            }
            if(a < b) {
                array[a] = array[b];
                a++;
            }

            while(a<b && array[a]<=x ){
                a++;
            }
            if(a < b) {
                array[b] = array[a];
                b--;
            }
        }
        array[a] = x;
        quickSort(array, start , a-1);
        quickSort(array, a+1, end);
    }


    /**
     * 插入排序
     * 向前插入
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr.length >= 2) {
            for (int i = 1; i < arr.length; i++) {
                //挖出一个要用来插入的值,同时位置上留下一个可以存新的值的坑
                int x = arr[i];
                int j = i - 1;
                //在前面有一个或连续多个值比x大的时候,一直循环往前面找,将x插入到这串值前面
                while (j >= 0 && arr[j] > x) {
                    //当arr[j]比x大的时候,将j向后移一位,正好填到坑中
                    arr[j + 1] = arr[j];
                    j--;
                }
                //将x插入到最前面
                arr[j + 1] = x;
            }
        }
    }


    public static void mergeSort(int[] a,int s,int e){
        int m = (s + e) / 2;
        if (s < e){
            mergeSort(a,s,m);
            mergeSort(a,m+1,e);
            //归并
            merge(a,s,m,e);
        }
    }

    private static void merge(int[] a, int s, int m, int e) {
        //初始化一个从起始s到终止e的一个数组
        int[] temp = new int[(e - s) + 1];
        //左起始指针
        int l = s;
        //右起始指针
        int r = m+1;
        int i = 0;
        //将s-e这段数据在逻辑上一分为二,l-m为一个左边的数组,r-e为一个右边的数组,两边都是有序的
        //从两边的第一个指针开始遍历,将其中小的那个值放在temp数组中
        while (l <= m && r <= e){
            if (a[l] < a[r]){
                temp[i++] = a[l++];
            }else{
                temp[i++] = a[r++];
            }
        }

        //将两个数组剩余的数放到temp中
        while (l <= m){
            temp[i++] = a[l++];
        }
        while (r <= e){
            temp[i++] = a[r++];
        }

        //将temp数组覆盖原数组
        for (int n = 0; n < temp.length; n++) {
            a[s+n] = temp[n];
        }

    }

    public static void main(String[] args) {
        // int[]  a={1,3,9,9,6,5,2,4,7,6};
        // quickSort(a, 0 ,9);
        // for (int i : a) {
        //     System.out.print(i);
        // }

        int[] arr = new int[200000];
        int[] test =getRandomArr(arr);
        long s = Clock.systemDefaultZone().millis();
        quickSort(test, 0, test.length - 1);
        System.out.println("quickSort耗时: " + (Clock.systemDefaultZone().millis() - s) + " ms");
    }

}
