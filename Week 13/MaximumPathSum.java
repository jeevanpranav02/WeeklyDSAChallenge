package Day_2;

import TreeNode.TreeNode;

import java.util.*;


// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int sum = Integer.MIN_VALUE;
        Map<TreeNode, Integer> maxRootPath = new HashMap<>();
        maxRootPath.put(null, 0);
        for (TreeNode node : postOrder(root)) {
            int left = Math.max(maxRootPath.get(node.left), 0);
            int right = Math.max(maxRootPath.get(node.right), 0);
            maxRootPath.put(node, Math.max(left, right) + node.val);
            sum = Math.max(left + right + node.val, sum);
        }
        return sum;
    }

    private Deque<TreeNode> postOrder(TreeNode root) {
        Deque<TreeNode> outerList = new LinkedList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                outerList.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return outerList;
    }
}
