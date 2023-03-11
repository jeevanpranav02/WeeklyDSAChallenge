package Day_2;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeOperations {

    //https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }

    //https://leetcode.com/problems/balanced-binary-tree/

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //https://leetcode.com/problems/diameter-of-binary-tree/
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] diameter = new int[1];
        findMaxDiameter(root,diameter);
        return diameter[0];
    }

    private int findMaxDiameter(TreeNode node, int[] max) {
        if(node == null) {
            return 0;
        }

        int leftHeight = findMaxDiameter(node.left, max);
        int rightHeight = findMaxDiameter(node.right, max);
        max[0] = Integer.max(max[0],leftHeight + rightHeight);
        return Integer.max(leftHeight,rightHeight) + 1;
    }
}
