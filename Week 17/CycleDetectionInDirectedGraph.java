package Day_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInDirectedGraph {
    public static void main(String[] args) {
        int V = 5;
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
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
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder[k++] = node;
            count++;
            for (int edge : adj.get(node)) {
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        return V == count;
    }
}
