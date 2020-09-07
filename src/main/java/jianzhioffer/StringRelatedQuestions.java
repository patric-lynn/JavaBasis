package jianzhioffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面试题05. 替换空格
 * 面试题20. 表示数值的字符串
 * 面试题50. 第一个只出现一次的字符
 */
public class StringRelatedQuestions {
    /**
     * 字符串替换测试
     *
     * @param str
     * @return
     */
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

    /**
     * 面试题05. 替换空格
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    /**
     * 面试题20. 表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、
     * "3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                //.之前不能出现.或者e
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                //e之前不能出现e，必须出现数
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false; //重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            } else if (str[i] == '-' || str[i] == '+') {
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }


    /**
     * 面试题50. 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
     * 示例:
     * s = "abaccdeff"
     * 返回 "b"
     * <p>
     * s = ""
     * 返回 " "
     * <p>
     * LinkedHashMap方法
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }

    //Hahmap方法
    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c)) return c;
        return ' ';
    }


}
