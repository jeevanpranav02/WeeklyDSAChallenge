package Day_5;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        LL list = new LL();
        for (int num : nums) {
            list.insertLast(num);
        }
        list.display();
        list.setHead(oddEvenList(list.getHead()));
        list.display();
    }

    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node oddHead = null;
        Node oddTail = null;
        Node evenHead = null;
        Node evenTail = null;
        Node curr = head;
        int i = 1;
        while (curr != null) {
            if (i % 2 == 1) {
                if (oddHead == null) {
                    oddHead = curr;
                    oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            } else {
                if (evenHead == null) {
                    evenHead = curr;
                    evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }
            curr = curr.next;
            i++;
        }
        if (evenTail != null) {
            evenTail.next = null;
        }
        oddTail.next = evenHead;
        return oddHead;
    }
}
