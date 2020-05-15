package basic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created on 2020/5/15.
 *
 * @author Duo Zhang
 */
public class file {
    /**
     * 文件处理测试
     * @throws IOException
     */
    public static void fileTest() throws IOException {
        File file = new File("src/main/java/basic/file/fileTest.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println("happy you");
        //先输出内容再输出一个回车
        printWriter.println("abcdefg");
        printWriter.close();
    }

    public static void main(String[] args){
        try{
            fileTest();
            System.out.println("文件输出成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
