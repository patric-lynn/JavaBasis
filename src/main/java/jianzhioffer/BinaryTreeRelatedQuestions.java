package jianzhioffer;

import java.util.HashMap;

/**
 * Description
 * 剑指 Offer 07. 重建二叉树: 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。[递归]
 * 剑指 Offer 26. 树的子结构: 输入两棵二叉树A和B，判断B是不是A的子结构。[递归]
 * @author Lynn-zd
 * @date Created on 2020/4/7 23:49
 */
public class BinaryTreeRelatedQuestions {
    /**
     * TreeNode定义
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
     * 面试题07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < pre.length; i++)
            map.put(inorder[i], i);
        return recursive(0, 0, inorder.length - 1);
    }

    TreeNode recursive(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null;
        TreeNode root = new TreeNode(pre[pre_root]);
        int i = map.get(pre[pre_root]);
        root.left = recursive(pre_root + 1, in_left, i - 1);
        root.right = recursive(pre_root + i + 1 - in_left, i + 1, in_right);
        return root;
    }


    /**
     * 剑指 Offer 26. 树的子结构
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 示例 1：
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


}
