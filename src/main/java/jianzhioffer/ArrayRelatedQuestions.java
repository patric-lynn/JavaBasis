package jianzhioffer;

import java.util.HashSet;

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

    public static void main(String[] args) {
        int[][] a= new int[][]{{1,2,3},{2,3,4},{4,5,6}};
    }
}