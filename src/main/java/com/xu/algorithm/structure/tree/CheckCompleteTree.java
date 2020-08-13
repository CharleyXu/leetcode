package com.xu.algorithm.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CharleyXu on 2020-08-13
 * <p>
 * 判断二叉树是不是完全二叉树
 */
public class CheckCompleteTree {

    private boolean flag;

    /**
     * 完全二叉树是指最后一层左边是满的，右边可能慢也不能不满，然后其余层都是满的，
     * <p>
     * 根据这个特性，利用层遍历。如果我们当前遍历到了NULL结点，如果后续还有非NULL结点，说明是非完全二叉树。
     *
     * @param root
     * @return
     */
    public boolean checkCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return true;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (flag == true)
                    return false;
                queue.add(node.left);
                queue.add(node.right);
            } else {
                flag = true;
            }
        }
        return true;
    }


}
