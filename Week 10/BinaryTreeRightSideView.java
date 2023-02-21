package Day_5;

import java.util.LinkedList;
import java.util.List;


  // Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        List<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) {
            return list;
        }
        queue.add(root);

        while(!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<TreeNode>();
            list.add(queue.get(0).val);
            for(TreeNode i : queue) {
                if(i.right != null)
                    temp.add(i.right);
                if(i.left != null)
                    temp.add(i.left);
            }
            queue = temp;
        }
        return list;
    }
}