package jianzhioffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 面试题03. 找到数组中重复的数字: 请找出一个长度为 n 的数组 nums 数组中任意一个重复的数字。[HashSet]
 * 面试题04. 二维数组中查找某一数: 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。[快慢指针]
 * 面试题11. 旋转数组的最小数字: 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。[二分法or线性遍历]
 * 面试题12. 矩阵中的路径: 查找字符矩阵中是否存在一个特定路径,如果存在则返回true，否则返回false。[DFS]
 * 面试题21. 调整数组顺序使奇数位于偶数前面: 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。[双指针法]
 * 面试题29. 顺时针打印矩阵: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。[边界遍历]
 * 面试题39. 数组中出现次数超过一半的数字: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。[哈希统计；数组排序；摩尔计数]
 * 面试题42. 连续子数组的最大和: 求所有子数组的和的最大值。[动态规划法；递推法]
 * 面试题45. 把数组排成最小的数: 把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。[Comparator]
 * 面试题51. 数组中的逆序对: 输入一个数组，求出这个数组中的逆序对的总数。[比较法]
 * 面试题53. I.在排序数组中查找数字: 统计一个数字在排序数组中出现的次数。[二分法]
 * 面试题53. II. 0～n-1中缺失的数字: 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。[二分法]
 */
public class ArrayMatrixRelatedQuestions {
    /**
     * 面试题03. 数组中重复的数字
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     * 示例 1：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int result = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Boolean flag = set.add(nums[i]);
            if (!flag) {
                result = nums[i];
                break;
            }
        }
        return result;
    }


    /**
     * 面试题04. 二维数组中的查找
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 解法一：暴力法，遍历数组[不推荐]
     * @param target
     * @param array
     * @return
     */
    public static boolean findNumberIn2DArray(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 面试题04.解法二：从左下角找
     */
    public static boolean findNumberIn2DArray2(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        int row = rows - 1;
        int col = 0;
        //注意限定范围，对于0起的是大于等于，到上限的是小于
        while (row >= 0 && col < cols) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 面试题04.解法三：从右上角找
     *
     * @param
     */
    public static boolean findNumberIn2DArray3(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        // 右上
        int row = 0;   //注意
        int col = cols - 1;    //注意
        while (row < rows && col >= 0) {    //注意
            if (array[row][col] < target) {
                row++;        //注意
            } else if (array[row][col] > target) {
                col--;      //注意
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 面试题11. 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * 示例 1：
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     * 输入：[2,2,2,0,1]
     * 输出：0
     * 解法一：线性遍历法
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 1) return numbers[0];
        int i = 1;
        if (numbers.length > 1) {
            while (numbers[i] >= numbers[i - 1]) {
                int a = i++;
                while (a == numbers.length - 1)
                    return numbers[0];
            }
            return numbers[i];
        }
        return -1;
    }

    /**
     * 面试题11.解法二：二分法。其可将遍历法的 线性级别 时间复杂度降低至 对数级别 。
     *
     * @param arrays
     * @return
     */
    public int minArray2(int[] arrays) {
        int i = 0, j = arrays.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (arrays[m] > arrays[j]) {
                i = m + 1;
            } else if (arrays[m] < arrays[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return arrays[i];
    }


    /**
     * 面试题12. 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
     * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     * 示例 1：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     *
     * 解法一：DFS
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 面试题12. 矩阵中的路径-深度搜索函数
     *
     */
    boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]) return false;
        if (k == words.length - 1) return true;
        char temp = board[i][j];
        //临时改变值，确保不相等；
        board[i][j] = '.';
        boolean result = dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i + 1, j, k + 1) ||
                         dfs(board, words, i, j - 1, k + 1) || dfs(board, words, i, j + 1, k + 1);
        board[i][j] = temp;
        return result;
    }


    /**
     * 面试题21. 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 示例：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     * 解法一：前后双指针法
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    /**
     * 面试题21 解法二：快慢双指针法
     *
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {//奇数
                if (slow != fast) {
                    nums[slow] ^= nums[fast];
                    nums[fast] ^= nums[slow];
                    nums[slow] ^= nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return nums;
    }


    /**
     * 面试题29. 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }


    /**
     * 面试题 39. 数组中出现次数超过一半的数字
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例 1:
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     *
     * 本题常见解法如下：
     * 1.哈希表统计法: 遍历数组nums，用 HashMap 统计各数字的数量，最终超过数组长度一半的数字则为众数。此方法时间和空间复杂度均为O(N)
     * 2.数组排序法: 将数组nums排序，由于众数的数量超过数组长度一半，因此 数组中点的元素 一定为众数。此方法时间复杂度O(Nlog2N)
     * 3.摩尔投票法: 核心理念为“正负抵消”; 时间和空间复杂度分别为O(N)和O(1); 是本题的最佳解法。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for (int num : nums)
            if (num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }

    /**
     * 面试题 39.解法二：哈希表法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                //这里不能直接map.get(nums[i])++;需要先判断是否存在
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            //注意：这里if不能放在第一个if中，否则会在数组长度为1时出错，无法返回正确的nums[i]的值
            //这里i>=length，之所以带等号，也是为了满足长度为1的情况，因为i从0开始
            //按照题目要求，必须众数次数超过长度的一半，则有第一个判断条件，相当于剪枝，当然下面的第一个判断条件也可以不加
            if (i >= length && map.get(nums[i]) > length) return nums[i];
        }
        return 0;//当不存在满足要求的数字或者数组长度为0时
    }


    /**
     * 面试题42. 连续子数组的最大和
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
     * 求所有子数组的和的最大值。
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
        for (int i = 1; i < nums.length; i++) {
            //当前值总是不小于nums[i]
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);
            //res的值为上一步的res与当前nums[i]中较大的
            res = Math.max(res, nums[i]);
        }
        return res;
    }


    /**
     * 面试题45. 把数组排成最小的数
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 示例 1:
     * 输入: [10,2]
     * 输出: "102"
     * 解法：
     * 通过在排序时传入一个自定义的 Comparator 实现，重新定义 String 列表内的排序方法，
     * 若拼接 s1 + s2 > s2 + s1，那么显然应该把 s2 在拼接时放在前面，
     * 以此类推，将整个 String 列表排序后再拼接起来。
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }


    /**
     * 面试题51. 数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组，求出这个数组中的逆序对的总数。
     * 示例 1:
     * 输入: [7,5,6,4]
     * 输出: 5
     *
     * 分治思想：在第 1 个子区间元素归并回去的时候，计算逆序对的个数。
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;

                count += (right - mid);
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;

                count += (j - mid - 1);
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
        return count;
    }


    /**
     * 面试题 53 - I. 在排序数组中查找数字
     * 统计一个数字在排序数组中出现的次数。
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * 解法一：二分法（中间值法）因为参数是整形，
     * 可以用二分查找 k-0.5、k+0.5 两数应该插入的位置，相减即次数。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return binarySearch(nums, target + 0.5) - binarySearch(nums, target - 0.5);
    }

    private int binarySearch(int[] nums, double target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 解法二：二分法:将二分查找右边界 rightright 的代码 封装至函数 helper()
     * 由于数组 numsnums 中元素都为整数，因此可以分别二分查找 targettarget 和
     * target - 1target−1 的右边界，将两结果相减并返回即可。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


    /**
     * 面试题53. II. 0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * 示例 1:
     * 输入: [0,1,3]
     * 输出: 2
     *
     * 时间复杂度 O(log N)O(logN)： 二分法为对数级别复杂度。
     * 空间复杂度 O(1)O(1)： 几个变量使用常数大小的额外空间。
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

}