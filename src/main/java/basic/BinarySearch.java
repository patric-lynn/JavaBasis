package basic;

/**
 * Created on 2020/9/7.
 *
 * @author Duo Zhang
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(recursionBinarySearch(array, 2, 0, 6));
        System.out.println(nonRecurBinarySearch(array, 4));
        System.out.println(findBinarySearch(7, 3, array));
    }

    /**
     * 使用递归的二分查找
     *
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int recursionBinarySearch(int[] array, int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                return recursionBinarySearch(array, key, low, mid - 1);
            } else if (key > array[mid]) {
                return recursionBinarySearch(array, key, mid + 1, high);
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 不使用递归实现二分查找（while循环）
     *
     * @param array
     * @param key
     * @return
     */
    public static int nonRecurBinarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 有条件二分查找：
     * 请实现有重复数字的有序数组的二分查找，输出在数组中第一个大于等于查找值的位置，
     * 如果数组中不存在这样的数，则输出数组长度加一
     *
     * @param n
     * @param v
     * @param array
     * @return
     */
    public static int findBinarySearch(int n, int v, int[] array) {
        if (n == 0)
            return 1;
        int left = 0;
        int right = n - 1;
        int index;
        while (left <= right) {
            index = (left + right) / 2;
            if (array[index] >= v) {
                if (index == 0 || array[index - 1] < v)
                    return index + 1;
                else
                    right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return n + 1;
    }
}
