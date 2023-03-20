package Day_7;

import Node.TreeNode;

import java.util.*;

public class AllNodeWithinKDistance {
    private static Map<TreeNode, TreeNode> map;

    public static ArrayList<Integer> KDistanceNodes(TreeNode root, int target, int k) {
        // return the sorted list of all nodes at k dist
        map = new HashMap<>();
        buildParentMap(root, null);
        Set<TreeNode> visited = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode targetNode = findNode(root, target);
        dfs(targetNode, visited, list, 0, k);
        Collections.sort(list);
        return list;
    }

    private static void dfs(TreeNode node, Set<TreeNode> visited, ArrayList<Integer> list, int dist, int k) {
        if (node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        if (dist == k) {
            list.add(node.value);
        } else if (dist < k) {
            dfs(node.left, visited, list, dist + 1, k);
            dfs(node.right, visited, list, dist + 1, k);
            dfs(map.get(node), visited, list, dist + 1, k);
        }
    }

    private static TreeNode findNode(TreeNode root, int targetData) {
        if (root == null) {
            return null;
        }

        if (root.value == targetData) {
            return root;
        }

        TreeNode leftNode = findNode(root.left, targetData);
        if (leftNode != null) {
            return leftNode;
        }

        TreeNode rightNode = findNode(root.right, targetData);
        if (rightNode != null) {
            return rightNode;
        }

        return null;
    }


    private static void buildParentMap(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        map.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}
