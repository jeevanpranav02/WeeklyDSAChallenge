package DailyChallenge;

public class SameTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        TreeNode tree2 = new TreeNode();
        tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);

        System.out.println(sameTreesTree(tree, tree2));
    }

    static boolean sameTrees = true;
    static boolean sameTreesTree(TreeNode p, TreeNode q) {
        checkTree(p,q);
        return sameTrees;
    }

    static void checkTree(TreeNode p, TreeNode q){
        System.out.println(sameTrees);
        if(p==null && q==null){
            return;
        }else if(p!=null && q!=null){
            if(p.val!=q.val){
                sameTrees = false;
                return;
            }
        }else{
            sameTrees = false;
            return;
        }

        if(sameTrees){
            checkTree(p.left,q.left);
        }
        if(sameTrees){
            checkTree(p.right,q.right);
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

