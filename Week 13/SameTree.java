package Day_3;

import Node.TreeNode;

public class SameTree {
    private boolean sameTrees = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        checkTree(p, q);
        return sameTrees;
    }

    private void checkTree(TreeNode p, TreeNode q) {
        System.out.println(sameTrees);
        if (p == null && q == null) {
            return;
        } else if (p != null && q != null) {
            if (p.value != q.value) {
                sameTrees = false;
                return;
            }
        } else {
            sameTrees = false;
            return;
        }

        if (sameTrees) {
            checkTree(p.left, q.left);
        }
        if (sameTrees) {
            checkTree(p.right, q.right);
        }
    }
}
