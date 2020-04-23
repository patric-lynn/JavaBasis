package jianzhioffer;

/**
 * Description
 * 面试题42. 连续子数组的最大和
 * @author Lynn-zd
 * @date Created on 2020/4/14 13:53
 */
public class DynamicRelatedQuestions {
    /**
     * 面试题42. 连续子数组的最大和
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 示例1:
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }


}
