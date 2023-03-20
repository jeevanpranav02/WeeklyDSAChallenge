package org.weeklydsa.Day_2;

import org.weeklydsa.Node.TreeNode;

import java.util.ArrayDeque;

public class InsertIntoBinaryTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            if (node.val > val) {
                if (node.left != null) {
                    queue.offerFirst(node.left);
                } else {
                    node.left = new TreeNode(val);
                }
            }
            if (node.val < val) {
                if (node.right != null) {
                    queue.offerFirst(node.right);
                } else {
                    node.right = new TreeNode(val);
                }
            }
        }
        return root;
    }
}
