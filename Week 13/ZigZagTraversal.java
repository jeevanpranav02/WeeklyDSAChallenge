package Day_3;

import Node.TreeNode;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> outer = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            level++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                inner.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(level % 2 == 0) {
                Collections.reverse(inner);
            }
            outer.add(inner);
        }
        return outer;
    }
}
