package leetCode;

import java.util.Arrays;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/13 23:33
 */
public class SortRelatedQuestions {
    public static void main(String[] args) {

    }
    public static Integer[] sort(){
        String a = "happy";
        Integer[] b = {1,2,3,4,5};
        Arrays.sort(b,(o1, o2)-> o2-o1);
        System.out.println(b[0]);
        return b;
    }
}
