package Day_7;

import Node.TreeNode;

import java.util.*;

public class BurningTree {
    public static int minTime(TreeNode root, int target) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        TreeNode targetNode = findNode(root, target);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(targetNode);

        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                visited.add(curr);

                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                }
                if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {
                    queue.add(parentMap.get(curr));
                }
            }
        }

        return time;
    }

    private static void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }

        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }

    private static TreeNode findNode(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        if (node.value == target) {
            return node;
        }

        TreeNode left = findNode(node.left, target);
        TreeNode right = findNode(node.right, target);

        return left != null ? left : right;
    }
}
