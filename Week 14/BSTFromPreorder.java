package org.weeklydsa.Day_5;

import org.weeklydsa.Node.TreeNode;

import java.util.Stack;

public class BSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int value = preorder[i];
            TreeNode node = new TreeNode(value);
            if (value < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode dummy = stack.peek();
                while (!stack.isEmpty() && value > stack.peek().val) {
                    dummy = stack.pop();
                }
                dummy.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
