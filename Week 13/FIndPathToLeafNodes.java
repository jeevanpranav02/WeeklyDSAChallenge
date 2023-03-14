package Day_5;

import Node.TreeNode;

import java.util.ArrayList;

public class FIndPathToLeafNodes {
    public ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        if (root == null) {
            return outer;
        }
        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(root.value);
        dfs(root, outer, inner);
        return outer;
    }

    private void dfs(TreeNode root, ArrayList<ArrayList<Integer>> outer, ArrayList<Integer> inner) {
        if (isLeaf(root)) {
            outer.add(new ArrayList<>(inner));
            return;
        }

        if (root.left != null) {
            inner.add(root.left.value);
            dfs(root.left, outer, inner);
            inner.remove(inner.size() - 1);
        }

        if (root.right != null) {
            inner.add(root.right.value);
            dfs(root.right, outer, inner);
            inner.remove(inner.size() - 1);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
