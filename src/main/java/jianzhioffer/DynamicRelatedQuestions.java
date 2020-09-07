package jianzhioffer;

/**
 * Description
 * 面试题42. 连续子数组的最大和:求所有子数组的和的最大值。[递推与动态规划]
 *
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
     * 解法一：递推法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    /**
     * 解法二：动态规划法
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0 ) return 0;
        //动态数组初始化
        int[] dp = new int[nums.length ];
        //初值初始化
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * 剑指 Offer 47. 礼物的最大价值
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * 示例 1:
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *
     * 解法：动态规划法
     * 题目说明：从棋盘的左上角开始拿格子里的礼物，并每次 向右 或者 向下 移动一格、直到到达棋盘的右下角。
     * 根据题目说明，易得某单元格只可能从上边单元格或左边单元格到达。
     * 设 f(i, j)为从棋盘左上角走至单元格 (i ,j)的礼物最大累计价值，易得到以下递推关系：
     * f(i,j)等于 f(i,j-1)和 f(i-1,j)中的较大值加上当前单元格礼物价值 grid(i,j)grid(i,j) 。
     * f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }



}
