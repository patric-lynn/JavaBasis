import java.util.ArrayList;

public class Solution {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 暴力法，遍历数组
     * @param target
     * @param array
     * @return  是否存在
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
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }


    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
         this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        ListNode li=listNode;
        while(li!=null){
            list.add(0,li.val);
            li=li.next;
        }
        return list;
    }


    public static void main(String[] args) {
        int[][] a= new int[][]{{1,2,3},{2,3,4},{4,5,6}};
        System.out.println(Find(6,a));
        System.out.println(Find2(6,a));
        System.out.println(Find3(6,a));
    }


}