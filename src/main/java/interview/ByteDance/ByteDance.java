package interview.ByteDance;

import java.util.Stack;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/9/3 00:29
 */
public class ByteDance {
    /**
     * 文件路径简化问题：利用堆栈模拟路径的上溯与下探
     * $ cd /a/
     * $ pwd
     * /a
     * @param path
     * @return
     */
    public static String simplifyFilePath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String value : s) {
            if (!stack.isEmpty() && "..".equals(value)) {
                stack.pop();
            } else if (!"".equals(value) && !".".equals(value)) {
                stack.push(value);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (String value : stack) {
            result.append("/").append(value);
        }

        return result.toString();
    }


    /**
     * 找出下一个大的数字
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        String s = "///a///bc";
        System.out.println(simplifyFilePath(s));
    }
}
