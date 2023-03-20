package org.weeklydsa.Day_4;

import org.weeklydsa.Node.TreeNode;

public class LCFofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = p.val, max = q.val;
        if (min > max) {
            min = q.val;
            max = p.val;
        }
        while (true) {
            if (root.val < min) {
                root = root.right;
            } else if (root.val > max) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}
