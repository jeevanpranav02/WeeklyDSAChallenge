package Day_7;

import Node.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildingTree {
    //Using in-order and pre-order
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    // It is similar to binary search
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> inMap) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRoot = inMap.get(root.value);
        // This is where the mid-index is determined
        int numsLeft = inRoot - inLeft;

        root.left = buildTree(preorder, preLeft + 1, preLeft + numsLeft, inorder, inLeft, inRoot - 1, inMap);
        root.right = buildTree(preorder, preLeft + numsLeft + 1, preRight, inorder, inRoot + 1, inRight, inMap);

        return root;
    }
}
