package org.weeklydsa.Day_4;

import org.weeklydsa.Node.TreeNode;

import java.util.Stack;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode parent = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (parent != null && root.val <= parent.val) {
                return false;
            }
            parent = root;
            root = root.right;
        }
        return true;
    }
}
