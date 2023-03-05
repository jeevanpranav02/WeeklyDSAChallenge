package Day_7;

import DoublyLinkedList_Files.DoublyLinkedList;
import DoublyLinkedList_Files.Node;

public class DeleteAllOccurancesOfXinDLL {
    public static void main(String[] args) {
        int[] nums = {2, 2, 10, 8, 4, 2, 5, 2};
        DoublyLinkedList list = new DoublyLinkedList();
        for (int num : nums) {
            list.addNodeBack(num);
        }
        list.displayForward();
        list.setHead(deleteAllOccurOfX(list.getHead(), 2));
        list.displayForward();
    }

    public static Node deleteAllOccurOfX(Node head, int x) {
        Node h = head;
        Node next;
        while (h != null) {
            if (h.data == x) {
                next = h.next;
                head = deleteNode(head, h);
                h = next;
            } else {
                h = h.next;
            }
        }
        return head;
    }

    private static Node deleteNode(Node head, Node node) {
        if (head == null || node == null) {
            return null;
        }
        if (head == node) {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        return head;
    }
}