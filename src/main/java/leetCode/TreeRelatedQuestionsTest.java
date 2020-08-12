package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeRelatedQuestionsTest {
    /**
     * 树节点
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 前序非递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return list;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.add(tmp.val);

            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历非递归
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
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
     * 后续遍历非递归
     *
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        TreeNode cur = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            if (tmp.left != null && tmp.left != cur && tmp.right != cur) {
                stack.push(tmp.left);
            }else if(tmp.right!=null && tmp.right!=cur){
                stack.push(tmp.right);
            }else {
                list.add(stack.pop().val);
                cur = tmp;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        System.out.println(preOrder(root));
        System.out.println(inOrder(root));
        System.out.println(postOrder(root));
    }

}
