package org.weeklydsa.Day_1;

import org.weeklydsa.Node.TreeNode;

public class CeilAndFloorInBST {
    public static int findCeil(TreeNode root, int key) {
        if (root == null) {
            return -1;
        }
        int ceil = -1;
        while (root != null) {
            if (root.val >= key) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }

    public static int floor(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int floor = 0;
        while (root != null) {
            if (root.val <= x) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}
