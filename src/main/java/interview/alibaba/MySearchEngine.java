package interview.alibaba;

import java.io.*;

/**
 * 整体方案：对多个文件构建索引,利用elasticSearch等全文搜索引擎实现是最方便的。由于时间关系，
 * 此处仅实现了针对单文件的关键字查找算法，待完成的功能有①针对多个文件查找关键字；
 * ②针对文件关键字建立索引加速查找；
 */

public class MySearchEngine {
    /**
     * 根据指定文件名与关键字，统计出现次数
     * @param file
     * @param keyword
     */
    public void SearchKeyword(File file,String keyword) {
        //参数校验
        verifyParam(file, keyword);

        //行读取
        LineNumberReader lineReader = null;
        try {
            lineReader = new LineNumberReader(new FileReader(file));
            String readLine = null;
            while((readLine =lineReader.readLine()) != null){
                //判断每一行中,出现关键词的次数
                int index = 0;
                int next = 0;
                //出现的次数
                int times = 0;
                //总计次数
                int count = 0;
                //判断次数
                while((index = readLine.indexOf(keyword,next)) != -1) {
                    next = index + keyword.length();
                    times++;
                }
                if(times > 0) {
                    count += times;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            close(lineReader);
        }
    }

    /**
     * 此处做文件名等参数校验
     * @param file
     * @param keyword
     */
    private void verifyParam(File file, String keyword) {
        //对参数进行校验证
        if(file == null ){
            throw new NullPointerException("the file is null");
        }
        if(keyword == null || keyword.trim().equals("")){
            throw new NullPointerException("the keyword is null or \"\" ");
        }

        if(!file.exists()) {
            throw new RuntimeException("the file is not exists");
        }
        //非目录
        if(file.isDirectory()){
            throw new RuntimeException("the file is a directory,not a file");
        }

        //可读取
        if(!file.canRead()) {
            throw new RuntimeException("the file can't read");
        }
    }

    /**
     * 关闭流
     */
    private void close(Closeable able){
        if(able != null){
            try {
                able.close();
            } catch (IOException e) {
                e.printStackTrace();
                able = null;
            }
        }
    }

    public static void main(String[] args) {

        MySearchEngine search = new MySearchEngine();
        search.SearchKeyword(new File("test.txt"), "中国");
    }


}
