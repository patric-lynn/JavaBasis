package interview;

import java.util.Stack;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/9/3 00:29
 */
public class ByteDance {
    /**
     * 文件路径简化
     * $ cd /a/
     * $ pwd
     * /a
     * @param path
     * @return
     */
    public static String simplifyFilePath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals("..")) {
                stack.pop();
            } else if (!s[i].equals("") && !s[i].equals(".")) {
                stack.push(s[i]);
            }
        }
        if (stack.isEmpty()) return "/";

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            result.append("/" + stack.get(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "/////a/////b";
        System.out.println(simplifyFilePath(s));
    }
}
