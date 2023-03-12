package Day_3;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryElementsOfTree {
    public ArrayList <Integer> boundary(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        if(!isLeaf(node)) {
            result.add(node.value);
        }
        leftElements(node, result);
        leafElements(node, result);
        rightElements(node, result);
        return result;
    }
    private void leftElements(TreeNode node, ArrayList<Integer> list) {
        TreeNode curr = node.left;
        while(curr != null) {
            if(!isLeaf(curr)) {
                list.add(curr.value);
            }
            if(curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }
    private void leafElements(TreeNode node, ArrayList<Integer> list) {
        if(isLeaf(node)) {
            list.add(node.value);
            return;
        }
        if(node.left != null) {
            leafElements(node.left, list);
        }
        if(node.right != null) {
            leafElements(node.right, list);
        }
    }
    private void rightElements(TreeNode node, ArrayList<Integer> list) {
        TreeNode curr = node.right;
        Stack<Integer> stack = new Stack<>();
        while(curr != null) {
            if(!isLeaf(curr)) {
                stack.push(curr.value);
            }
            if(curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }
    private Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
}
