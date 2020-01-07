/**
 *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */
public class Solution {
    /**
     * 暴力法，遍历数组
     * @param target
     * @param array
     * @return  是否存在
     */
    public boolean Find(int target, int [][] array) {
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
    public boolean Find2(int target, int [][] array) {
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


}