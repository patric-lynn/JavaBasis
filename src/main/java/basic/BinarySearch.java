package basic;

import java.util.Arrays;

/**
 * Created on 2020/9/7.
 *
 * @author Duo Zhang
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{8, 10, 11, 1, 3, 4, 7};
        int p1 = 9;
        int p2 = 3;
        boolean b1 = isExist(array, p1);
        boolean b2 = isExist(array, p2);
        System.out.println(b1 + " " + b2);
    }


    public static boolean isExist(int[] array, int p) {
        int temp = binarySearch(array, 0, array.length - 1, p);
        if (temp == -1) return false;
        return true;
    }

    public static int binarySearch(int[] array, int start, int end, int p) {
        int middle = (start + end) / 2;
        if (p == array[middle]) {
            return middle;
        }
        if (array[middle] < array[start]) {
            binarySearch(Arrays.copyOfRange(array,middle + 1, end), middle + 1, end, p);
        } else if (array[middle] > array[end]) {
            binarySearch(Arrays.copyOfRange(array, start, middle - 1), start, middle - 1, p);
        }
        return -1;
    }
}
