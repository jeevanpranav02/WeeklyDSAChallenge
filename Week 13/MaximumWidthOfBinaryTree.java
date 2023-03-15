package Day_6;

import Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public int getMaxWidth(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            maxWidth = Math.max(maxWidth, queue.size());
        }
        return maxWidth;
    }
}
