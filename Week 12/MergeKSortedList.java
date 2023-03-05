package Day_3;

import Node.Node;

import java.util.PriorityQueue;

public class MergeKSortedList {
        public static Node mergeKLists(Node[] lists) {
            PriorityQueue<ListPair> pq = new PriorityQueue<>(
                    (a, b) -> a.value - b.value
            );
            for (Node head : lists) {
                while(head != null){
                    pq.add(new ListPair(head.value , head));
                    head = head.next;
                }
            }
            if(pq.size() == 0) {
                return null;
            }
            Node head = pq.poll().node;
            Node temp = head;
            temp.next = null;
            while(!pq.isEmpty()){
                temp.next = pq.poll().node;
                temp = temp.next;
                temp.next = null;
            }
            return head;
        }
}
class ListPair {
    int value;
    Node node;
    ListPair() {}
    ListPair(int value, Node node) {
        this.value = value;
        this.node = node;
    }
}