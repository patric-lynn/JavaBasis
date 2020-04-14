package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description
 * 215. 数组中的第K个最大元素
 * 239. 滑动窗口最大值
 * 347. 前 K 个高频元素
 * @author Lynn-zd
 * @date Created on 2020/3/13 21:43
 */
public class HeapRelatedQuestions {
    /**
     * 215. 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    /**
     * 239. 滑动窗口最大值
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     * 示例:
     * <p>
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                  最大值
     * ---------------              -----
     * [1  3  -1] -3  5  3  6  7      3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     *  
     * <p>
     * 提示：
     * <p>
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }


    /**
     * 347. 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     *
     * 解法：利用一个hashmap保存当前数与出现次数，然后利用最小堆不断输出最小值
     * ，剩余的k个元素必定是出现频次最高的K个元素
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        //构建hashmap，存储每个数字；
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        //构建最小堆,利用lambda表达式反序,此处注意一定是get到的值小序，不要直接比大小；
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) ->hashMap.get(o1) - hashMap.get(o2)));
        //输入并调整堆直到剩下k个元素；
        for (int i : hashMap.keySet()) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        //保存剩余的k个数值，并返回List中；
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 3, 4, 3, 3, 2, 2, 1, 5, 6, 4};
        int k = 3;
        /**
         * 215. 数组中的第K个最大元素
         */
        System.out.println(findKthLargest(nums, k));

        /**
         * 239. 滑动窗口最大值
         * 注意，print方法和println方法不能输出数组
         */
        for (int i = 0; i < nums.length - k + 1; i++) {
            System.out.print(maxSlidingWindow(nums, k)[i] + " ");
        }

        /**
         * 347. 前 K 个高频元素
         */
        System.out.println("\n"+topKFrequent(nums, k));
    }

}
