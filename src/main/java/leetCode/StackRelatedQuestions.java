package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Description
 * LeetCode 栈相关问题
 * 20. 有效的括号
 * 94. 二叉树的中序遍历(三种方法)
 * @author Lynn-zd
 * @date Created on 2020/3/11 12:30
 */
public class StackRelatedQuestions {
    public static void main(String[] args) {
        String string = "[[{{(())}}]]";
        System.out.println("括号匹配第一种解法的结果：" + isValid(string));
        System.out.println("括号匹配第二种解法的结果：" + isValid2(string));

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        System.out.println(inorderTraversal(a));
        System.out.println(inorderTraversal2(a));
        System.out.println(inorderTraversal3(a));
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * 解法一
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


    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树，返回它的中序 遍历。
     * 示例:
     * 输入: [1,null,2,3]
     * 输出: [1,3,2]
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 解法一：递归法
     *
     * @param root
     * @return
     */
    static List<Integer> list = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            if (root.left != null) inorderTraversal(root.left);
            list.add(root.val);
            if (root.right != null) inorderTraversal(root.right);
        }
        return list;
    }

    /**
     * 解法二：非递归法
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * 解法三：颜色标记法（非递归，最佳方法）
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal3(TreeNode root) {
        class ColorNode {
            TreeNode node;
            String color;
            ColorNode(TreeNode node, String color) {
                this.node = node;
                this.color = color;
            }
        }
        List<Integer> list = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        if (root != null) {
            stack.push(new ColorNode(root, "white"));
            while (!stack.empty()) {
                ColorNode curr = stack.pop();
                if (curr.color.equals("white")) {
                    if (curr.node.right != null) stack.push(new ColorNode(curr.node.right, "white"));
                    stack.push(new ColorNode(curr.node, "gray"));
                    if (curr.node.left != null) stack.push(new ColorNode(curr.node.left, "white"));
                } else {
                    list.add(curr.node.val);
                }
            }
        }
        return list;
    }


}
