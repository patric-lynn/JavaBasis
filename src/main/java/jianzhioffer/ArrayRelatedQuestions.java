package jianzhioffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 面试题03. 找到数组中重复的数字
 * 面试题04. 二维数组中查找某一数
 * 面试题11. 旋转数组的最小数字
 * 面试题12. 矩阵中的路径
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 面试题29. 顺时针打印矩阵
 * 面试题45. 把数组排成最小的数
 */
public class ArrayRelatedQuestions {
    /**
     * 面试题03. 数组中重复的数字
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
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
        for(int i=0; i<nums.length; i++){
            Boolean flag = set.add(nums[i]);
            if(!flag) {
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
     * 暴力法，遍历数组
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        for (int i=0; i<array.length;i++){
            for (int j=0;j<array[0].length;j++){
                if(array[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 从左下角找
     */
    public static boolean Find2(int target, int [][] array) {
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;
        if(cols==0){
            return false;
        }
        int row=rows-1;
        int col = 0;
        while (row>=0 && col<cols){
            if(array[row][col]<target){
                col++;
            }
            else if(array[row][col]>target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }
    /**
     * 从右上角找
     * @param
     */
    public static boolean Find3(int target, int [][] array) {
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;
        if(cols == 0){
            return false;
        }
        // 右上
        int row = 0;   //注意
        int col = cols-1;    //注意
        while(row<rows && col>=0){    //注意
            if(array[row][col] < target){
                row++;        //注意
            }else if(array[row][col] > target){
                col--;      //注意
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 面试题11. 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * 示例 1：
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     *
     * 输入：[2,2,2,0,1]
     * 输出：0
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if(numbers.length == 1) return numbers[0];
        int i = 1;
        if(numbers.length >1){
            while(numbers[i]>=numbers[i-1]) {
                int a = i++;
                while(a == numbers.length-1)
                    return numbers[0];
            }
            return numbers[i];
        }
        return -1;
    }


    /**
     * 面试题12. 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     * 示例 1：
     *
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i=0; i< board.length; i++)
            for(int j=0; j< board[0].length; j++){
                if(dfs(board,words,i,j,0)) return true;
            }
        return false;
    }
    boolean dfs(char[][] board, char[] words, int i, int j, int k){
        if(i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=words[k] ) return false;
        if(k == words.length-1) return true;
        char temp = board[i][j];
        board[i][j] = '.';   //临时改变值，确保不相等；
        boolean result = dfs(board,words,i-1,j,k+1)||dfs(board,words,i+1,j,k+1)||dfs(board,words,i,j-1,k+1)||dfs(board,words,i,j+1,k+1);
        board[i][j] = temp;
        return result;
    }


    /**
     * 面试题21. 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 示例：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
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
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
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
     * 通过在排序时传入一个自定义的 Comparator 实现，重新定义 String 列表内的排序方法，若拼接 s1 + s2 > s2 + s1，那么显然应该把 s2 在拼接时放在前面，以此类推，将整个 String 列表排序后再拼接起来。
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
}