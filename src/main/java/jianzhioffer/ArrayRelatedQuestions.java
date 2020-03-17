package jianzhioffer;

public class ArrayRelatedQuestions {
    //测试一维数组属性 2020-3-3
    public static void Array() {
        int[] a = {1, 2, 3};
        int[] bo = a;
        System.out.println(a.length + bo.length);
    }


    int[][] a= new int[][]{{1,2,3},{2,3,4},{4,5,6}};
    /**
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
}