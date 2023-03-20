package org.weeklydsa.Day_3;

import org.weeklydsa.Node.TreeNode;

public class DeleteBSTNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }

        if(root.val == key) {
            return deleteUtil(root);
        }
        TreeNode node = root;
        while(node != null) {
            if(node.val <= key) {
                if(node.right != null && node.right.val == key) {
                    node.right = deleteUtil(node.right);
                    break;
                } else {
                    node = node.right;
                }
            } else {
                if(node.left != null && node.left.val == key) {
                    node.left = deleteUtil(node.left);
                    break;
                } else {
                    node = node.left;
                }
            }
        }
        return root;
    }

    private TreeNode deleteUtil(TreeNode node) {
        if(node.left == null) {
            return node.right;
        }
        if(node.right == null) {
            return node.left;
        }
        TreeNode right = node.right;
        TreeNode lastChild = findLastChild(node.left);
        lastChild.right = right;
        return node.left;
    }

    private TreeNode findLastChild(TreeNode node) {
        if(node.right == null) {
            return node;
        }
        return findLastChild(node.right);
    }
}
