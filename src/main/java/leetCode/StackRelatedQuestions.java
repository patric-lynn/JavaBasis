package leetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Description
 * LeetCode 栈相关问题
 *
 * @author Lynn-zd
 * @date Created on 2020/3/11 12:30
 */
public class StackRelatedQuestions {
    public static void main(String[] args) {
        String string = "[[{{(())}}]]";
        System.out.println("括号匹配第一种解法的结果：" + isValid(string));
        System.out.println("括号匹配第二种解法的结果：" + isValid2(string));
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
            }
            if (c[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if ('(' != stack.pop()) {
                    return false;
                } else {
                    continue;
                }
            }
            if (c[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else if ('{' != stack.pop()) {
                    return false;
                } else {
                    continue;
                }
            }
            if (c[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if ('[' != stack.pop()) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 方法2，利用hashmap来保存括号对来进行匹配
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
