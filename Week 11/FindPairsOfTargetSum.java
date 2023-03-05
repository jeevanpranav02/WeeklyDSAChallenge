package Day_7;

import DoublyLinkedList_Files.DoublyLinkedList;
import DoublyLinkedList_Files.Node;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindPairsOfTargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 7, 8, 9};
        DoublyLinkedList list = new DoublyLinkedList();
        for (int num : nums) {
            list.addNodeBack(num);
        }
        list.displayForward();
        System.out.println(findPairsWithGivenSum(7, list.getHead()));
        list.displayForward();
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        if (head == null) {
            return new ArrayList<>();
        }
        Set<ArrayList<Integer>> outer = new LinkedHashSet<>();
        Node fast = head;
        Node temp = head;
        Node tail = null;
        while (fast.next != null) {
            fast = fast.next;
        }
        tail = fast;
        while (temp != fast && temp.next != null && fast.prev != null) {
            int sum = fast.data + temp.data;
            if (sum == target) {
                ArrayList<Integer> inner = new ArrayList<>();
                inner.add(temp.data);
                inner.add(fast.data);
                ArrayList<Integer> revInner = new ArrayList<>();
                revInner.add(fast.data);
                revInner.add(temp.data);
                if(!outer.contains(revInner)) {
                    outer.add(inner);
                }
                fast = fast.prev;
                temp = temp.next;
            } else if (sum > target) {
                fast = fast.prev;
            } else {
                temp = temp.next;
            }
        }
        return new ArrayList<>(outer);
    }
}
