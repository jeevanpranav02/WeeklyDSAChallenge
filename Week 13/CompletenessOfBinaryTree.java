package Day_6;

import Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CompletenessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(current.left);
            }
            if (current.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(current.right);
            }
        }
        return true;
    }
}
