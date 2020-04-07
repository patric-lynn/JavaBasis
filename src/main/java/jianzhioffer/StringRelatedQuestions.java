package jianzhioffer;

public class StringRelatedQuestions {
    /**
     * 面试题05. 替换空格
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    //字符串替换测试
    public static String replaceSpace(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i++) {
            char c = stringBuffer.charAt(i);
            if (c == ' ') {
                buffer.append("%20");
            } else { //注意此处必须是二选一的形式!!!!!!!!!!!!!!!!!!!!!!!如果没有else子句，则空格也会被加上!!!!!!!!!!!
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

}
