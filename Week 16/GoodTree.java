package Daily_Challenge.GFG;

import Node.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GoodTree {
    public static void main(String[] args) {
        Node root = new Node();
        root.data = 1;
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        int k = 2;
        System.out.println(goodSubtrees(3, root));

    }

    private static int goodSubtrees(int k, Node root) {
        int[] goodTrees = new int[1];
        dfs(k, root, goodTrees);
        return goodTrees[0];
    }

    private static Set<Integer> dfs(int k, Node root, int[] goodTrees) {
        Set<Integer> allSubTrees = new HashSet<>();
        if (root == null) {
            return allSubTrees;
        }
        Set<Integer> leftSubTrees = dfs(k, root.left, goodTrees);
        Set<Integer> rightSubTrees = dfs(k, root.right, goodTrees);
        allSubTrees.add(root.data);
        allSubTrees.addAll(leftSubTrees);
        allSubTrees.addAll(rightSubTrees);
        if(allSubTrees.size() <= k) {
            goodTrees[0]++;
        }
        return allSubTrees;
    }

    private static int goodSubtreesBRUTEFORCE(int k, Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            if (bfsBRUTEFORCE(k, curr)) {
                count++;
            }
        }
        return count;
    }

    private static boolean bfsBRUTEFORCE(int k, Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Set<Integer> set = new HashSet<>();
        while(!queue.isEmpty()) {
            if(set.size() > k) {
                return false;
            }
            Node curr = queue.poll();
            if(curr.left != null) {
                queue.offer(curr.left);
            }
            if(curr.right != null) {
                queue.offer(curr.right);
            }
            set.add(curr.data);
        }
        return true;
    }
}
