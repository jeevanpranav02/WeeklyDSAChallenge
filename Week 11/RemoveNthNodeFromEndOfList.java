package Day_6;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LL list = new LL();
        for (int num : nums) {
            list.insertLast(num);
        }
        list.display();
        list.setHead(removeNthFromEnd(list.getHead(), 2));
        list.display();
    }

    public static Node removeNthFromEnd(Node head, int n) {
        int count = 0;
        if (head.next == null) {
            return null;
        }
        Node slow = head;
        while (slow.next != null) {
            count++;
            slow = slow.next;
        }
        slow = head;
        count = count - n;
        if (count < 0) {
            head = head.next;
        } else {
            for (int i = 0; i < count; i++) {
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}
