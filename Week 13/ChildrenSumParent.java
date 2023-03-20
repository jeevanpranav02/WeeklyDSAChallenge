package Day_7;

import Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumParent {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(10);
        System.out.println(isSumProperty(root));
    }

    public static int isSumProperty(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(isLeaf(node)) {
                    continue;
                }
                int value = node.value;
                int childSum = 0;
                if (node.left != null) {
                    queue.offer(node.left);
                    childSum += node.left.value;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    childSum += node.right.value;
                }
                if (childSum != value) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}