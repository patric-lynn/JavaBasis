package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Description
 * 101. 对称二叉树
 * 104. 二叉树的最大深度
 * 144. 二叉树的前序遍历
 * 543. 二叉树的直径
 *
 * @author Lynn-zd
 * @date Created on 2020/3/15 18:14
 */
public class TreeRelatedQuestions {
    private static int count = 0;

    /**
     * 二叉树定义
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
     * 101. 对称二叉树
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * 解法一：递归法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    /**
     * 解法二：非递归法
     *
     * @param root
     * @return
     */
    public boolean isSymmetricNonRecursive(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


    /**
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     *
     * @param root
     * @return count
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        count = (left > right) ? left : right;
        return count;
    }


    /**
     * 144. 二叉树的前序遍历
     * 递归解法
     * @param root
     */
    static List<Integer> listPreOrder = new ArrayList<>();
    public static List<Integer> preOrderRecur(TreeNode root) {
        if (root == null) {
            return listPreOrder;
        }
        listPreOrder.add(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
        return listPreOrder;
    }
    /**
     * 非递归解法
     * @param root
     * @return
     */
    public static List<Integer> preOrderNonRecur(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }



    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树，返回它的中序 遍历。
     * 示例:
     * 输入: [1,null,2,3]
     * 输出: [1,3,2]
     *
     * 解法一：递归法
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
    

    /**
     * 543. 二叉树的直径
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     * 给定二叉树
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     *
     * @param root
     * @return count
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return count;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        count = Math.max(count, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(preOrderRecur(root));
        System.out.println(preOrderNonRecur(root));
    }
}
