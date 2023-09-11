package Day_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {
    public static void main(String[] args) {

    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int edge : adj.get(i)) {
                inDegree[edge]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] topoOrder = new int[V];
        int k = 0;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
//            int node = queue.poll();
            topoOrder[k++] = node;

            for (int edge : adj.get(node)) {
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        return topoOrder;
    }
}
