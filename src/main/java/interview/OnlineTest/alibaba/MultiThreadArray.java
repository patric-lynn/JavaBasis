package interview.OnlineTest.alibaba;

/**
 * Description
 * 评测题目: 实现void multiThreadPrint(String[] input)，
 * 在内部要求启动N个线程分别输出input数组内的内容，
 * N为input数组的长度。要求：
 * 1. 在屏幕上数据输出顺序为input数组内的顺序
 * 2. 该函数内必须等待所有数据输出完毕后退出。
 * @author Lynn-zd
 * @date Created on 2020/5/16 17:58
 */
public class MultiThreadArray implements Runnable {
    private static int n;
    private static String[] array;
    private static int i = 0;

    public static void setArray(String[] arr) {
        array = arr;
        n = array.length;
    }

    @Override
    public void run() {
        if (i < array.length) {
            System.out.println(Thread.currentThread().getName() + " 输出字符串 " + array[i++]);
        }
    }

    public static synchronized void multiThreadPrint(String[] input) {
        setArray(input);
        for (int i = 0; i < n; i++) {
            new Thread(new MultiThreadArray(),"线程"+i).start();
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "happy", "we", "china", "protocol","boy","girl","america","chinese","big","small"};
        multiThreadPrint(strings);
    }
}
