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
     * 文件路径简化问题：利用堆栈模拟路径的上溯与下探
     * $ cd /a/
     * $ pwd
     * /a
     * @param path
     * @return
     */
    public static String simplifyFilePath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String value : s) {
            if (!stack.isEmpty() && "..".equals(value)) {
                stack.pop();
            } else if (!"".equals(value) && !".".equals(value)) {
                stack.push(value);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (String value : stack) {
            result.append("/").append(value);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "/////a/////b";
        System.out.println(simplifyFilePath(s));
    }
}
