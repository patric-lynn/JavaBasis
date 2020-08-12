package leetCode;

/**
 * Description
 * 45. 跳跃游戏 II: 使用最少的跳跃次数到达数组的最后一个位置。
 * 55. 跳跃游戏: 判断你是否能够到达最后一个位置。
 *
 * @author Lynn-zd
 * @date Created on 2020/3/17 22:37
 */
public class GreedyRelatedQuestions {
    /**
     * 45. 跳跃游戏 II
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 示例:
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 说明:
     * 假设你总是可以到达数组的最后一个位置。
     *
     * 解法介绍：首先是循环体结束位置为length-1，因为step加一了
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int step = 0;
        int maxPosition = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    /**
     * 55. 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     * 示例 1:
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 1, 3, 4, 2, 1, 1};
        System.out.println(jump(a));
        System.out.println(canJump(a));
    }
}
