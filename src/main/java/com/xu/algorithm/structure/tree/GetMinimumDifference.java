package com.xu.algorithm.structure.tree;

/**
 * Created by CharleyXu on 2020-05-06
 * <p>
 * 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference {

    private TreeNode preNode = null;
    private int result = Integer.MAX_VALUE;

    /**
     * 给你一棵所有节点为非负值的二叉搜索树
     * <p>
     * 请你计算树中任意两节点的差的绝对值的最小值
     *
     * BST中序遍历是升序，所以遍历时求相邻两个节点之间的最小绝对差值
     */
    public int getMinimumDifference(TreeNode root) {
        getMinimumDiff(root);
        return result;
    }

    private void getMinimumDiff(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinimumDiff(root.left);
        if (preNode != null) {
            result = Math.min(Math.abs(root.val - preNode.val), result);
        }
        preNode = root;
        getMinimumDiff(root.right);
    }
}
