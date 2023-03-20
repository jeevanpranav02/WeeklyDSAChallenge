package org.weeklydsa.Day_1;

import java.util.ArrayList;

public class PrintAdjacencyList {
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            list.add(new ArrayList<>());
            list.get(i).add(i);
            list.get(i).addAll(adj.get(i));
        }
        return list;
    }
}
