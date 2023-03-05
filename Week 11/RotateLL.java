package Day_7;

import LinkedList_Files.LL.Node;
import LinkedList_Files.LL;

public class RotateLL {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LL list = new LL();
        for (int i = 0; i < nums.length; i++) {
            list.insert(nums[i], i);
        }
        System.out.println("Before Rotating");
        list.display();
        Node newHead = rotateRight(list.getHead(), 2);
        System.out.println("After Rotating");
        list.setHead(newHead);
        list.display();
    }

    public static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getSize(head);
        k = k % length;
        for (int i = 0; i < k; i++) {
            Node node = head;
            while (node.next.next != null) {
                node = node.next;
            }
            Node tail = node.next;
            node.next = null;
            tail.next = head;
            head = tail;
        }
        return head;
    }

    private static int getSize(Node head) {
        int count = 0;
        Node h = head;
        while(h != null) {
            count++;
            h = h.next;
        }
        return count;
    }
}
