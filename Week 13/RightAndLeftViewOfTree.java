package Day_5;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightAndLeftViewOfTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        List<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return list;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<TreeNode>();
            list.add(queue.get(0).value);
            for (TreeNode i : queue) {
                if (i.right != null) {
                    temp.add(i.right);
                }
                if (i.left != null) {
                    temp.add(i.left);
                }
            }
            queue = temp;
        }
        return list;
    }

    public List<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<TreeNode>();
            list.add(queue.get(0).value);
            for (TreeNode i : queue) {
                if (i.left != null) {
                    temp.add(i.left);
                }
                if (i.right != null) {
                    temp.add(i.right);
                }
            }
            queue = temp;
        }
        return list;
    }
}
