package Day_4;

import Node.TreeNode;
import Node.Pair;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class TopViewOfBinaryTree {
    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int distance = pair.getValue();
            TreeNode temp = pair.getKey();
            if (!map.containsKey(distance)) {
                map.put(distance, temp.value);
            }
            if (temp.left != null) {
                queue.offer(new Pair(temp.left, distance - 1));
            }
            if (temp.right != null) {
                queue.offer(new Pair(temp.right, distance + 1));
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            list.add(e.getValue());
        }
        return list;
    }
}
