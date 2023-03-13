package Day_4;

import Node.TreeNode;
import Node.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class LevelOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();
        if (root == null) {
            return outer;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();

                TreeNode node = p.getKey();
                int hd = p.getValue();

                if (levelMap.containsKey(hd)) {
                    levelMap.get(hd).add(node.value);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(node.value);
                    levelMap.put(hd, list);
                }

                if (node.left != null) {
                    queue.offer(new Pair(node.left, hd - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, hd + 1));
                }
            }

            for (int hd : levelMap.keySet()) {
                List<Integer> list = levelMap.get(hd);
                Collections.sort(list);
                map.putIfAbsent(hd, new ArrayList<>());
                map.get(hd).addAll(list);
            }
        }

        for (int hd : map.keySet()) {
            outer.add(map.get(hd));
        }
        return outer;
    }
}

