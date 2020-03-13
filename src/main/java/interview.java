import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class interview {
    //字符串替换测试
    public static String replace(StringBuffer str) {
        StringBuffer str1 = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                str1.append("%20");
            } else { //注意此处必须是二选一的形式!!!!!!!!!!!!!!!!!!!!!!!如果没有else子句，则空格也会被加上!!!!!!!!!!!
                str1.append(c);
            }
        }
        return str1.toString();
//        return str.toString().replace(" ", "%20");
    }

    //ArrayList测试
    public class ListNode {
        int val;
        basic.ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(basic.ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        basic.ListNode li = listNode;
        while (li != null) {
            list.add(0, li.val);
            li = li.next;
        }
        return list;
    }

    //文件处理测试
    public static void fileTest() throws IOException {
        File file = new File("fileTest.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.print("happy you");
        //先输出内容再输出一个回车
        printWriter.println("bcde");
        printWriter.close();
    }

    public static Integer[] sort(){
        String a = "happy";
        Integer[] b = {1,2,3,4,5};
        Arrays.sort(b,(o1,o2)-> o2-o1);
        System.out.println(b[0]);
        return b;
    }

    public static void main(String[] args) {

    }
}
