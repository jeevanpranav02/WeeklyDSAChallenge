package org.weeklydsa.Day_5;

import org.weeklydsa.Node.TreeNode;

public class PredecessorAndSuccessor {
    public static void findPreSuc(TreeNode root, Res p, Res s, int key) {
        if (root == null) {
            return;
        }
        if (root.val == key) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                p.pre = temp;
            }
            if (root.right != null) {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                s.succ = temp;
            }
            return;
        }
        if (root.val > key) {
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        } else {
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        }
    }

    static class Res {
        TreeNode pre;
        TreeNode succ;
    }
}
