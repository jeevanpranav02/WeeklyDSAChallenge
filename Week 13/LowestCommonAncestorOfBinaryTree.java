package Day_5;

import Node.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    //HashMap approach using hashmap
    // Using a hash table: We can traverse the binary tree and store each node and its parent in
    // a hash table. Then, we can use the hash table to find the lowest common ancestor of two
    // nodes by traversing up from the two nodes until we find a common node.


    /*
    *       1
           / \
          2   3
         / \   \
        4   5   6

        hash_table = {
            1: None,
            2: 1,
            3: 1,
            4: 2,
            5: 2,
            6: 3
        }

       Path :
        Path from 4 to root: 4 -> 2 -> 1
        Path from 5 to root: 5 -> 2 -> 1

    *
    *
    *
    *
    */




     public TreeNode lowestCommonAncestorUsingHashMap(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        map.put(root, null);
        stack.push(root);

        while(!stack.isEmpty() && (!map.containsKey(p) || !map.containsKey(q))) {
            TreeNode curr = stack.pop();

            if (curr.left != null) {
                map.put(curr.left, curr);
                stack.push(curr.left);
            }

            if (curr.right != null) {
                map.put(curr.right, curr);
                stack.push(curr.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }

        while (!ancestors.contains(q)) {
            q = map.get(q);
        }

        return q;
    }
}
