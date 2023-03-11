package Week13.Day1;

import Week13.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversal {
    private static ArrayList<Integer> findSpiral(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        boolean reverse = true;
        queue.add(root);
        while (queue.isEmpty() == false) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = queue.poll();
                if (reverse) {
                    stack.add(curr.val);
                } else {
                    list.add(curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (reverse) {
                while (stack.isEmpty() == false) {
                    list.add(stack.pop());
                }
            }
            reverse = !reverse;
        }
        return list;
    }
}