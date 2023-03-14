package Daily_Challenges;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null) {
            return sum;
        }
        List<List<Integer>> outer = Paths(root);
        for(List<Integer> inner : outer) {
            sum += convertListToInt(inner);
        }
        return sum;
    }
    private int convertListToInt(List<Integer> list) {
        int n = 0;
        for(int num : list) {
            n = (n * 10) + num;
        }
        return n;
    }
    private List<List<Integer>> Paths(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();
        if (root == null) {
            return outer;
        }
        List<Integer> inner = new ArrayList<>();
        inner.add(root.value);
        dfs(root, outer, inner);
        return outer;
    }

    private void dfs(TreeNode root, List<List<Integer>> outer, List<Integer> inner) {
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
