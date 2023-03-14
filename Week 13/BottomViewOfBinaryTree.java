package Day_5;


import java.util.*;

public class BottomViewOfBinaryTree {
    public ArrayList <Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        //This map will sort the values relative to the distance of the node.
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        //Assigning the horizontal distance of the root as 0
        root.hd = 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int dist = node.hd;
            map.put(dist, node.data);
            if(node.left != null) {
                node.left.hd = dist - 1;
                queue.add(node.left);
            }
            if(node.right != null) {
                node.right.hd = dist + 1;
                queue.add(node.right);
            }
        }
        for(int data : map.values()) {
            list.add(data);
        }

        return list;
    }

    class Node {
        int data;
        int hd;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
