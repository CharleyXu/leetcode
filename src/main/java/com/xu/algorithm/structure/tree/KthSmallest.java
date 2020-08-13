package com.xu.algorithm.structure.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by CharleyXu on 2020-06-02
 * <p>
 * 二叉搜索树中第K小的元素
 */
public class KthSmallest extends BaseTreeNode {

    /**
     * 中序遍历 (单调递增)
     * <p>
     * 二叉搜索树的性质：对于树中的任意非叶子节点 node，
     * <p>
     * 它的左子树的所有节点的值都小于 node.val，
     * <p>
     * 且它的右子树的所有节点的值都大于 node.val
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 0) {
            return 0;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                count++;
                if (count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    @Test
    public void kthSmallestTest() {
        System.out.println(kthSmallest(root, 6));
    }

}
