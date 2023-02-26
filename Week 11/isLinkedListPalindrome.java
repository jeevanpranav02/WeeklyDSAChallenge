package Day_3;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;


public class isLinkedListPalindrome {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
        LL list = new LL();
        for (int num : nums) {
            list.insertLast(num);
        }
        list.display();
        System.out.println(isPalindrome(list.getHead()));
        list.display();
    }

    private static boolean isPalindrome(Node head) {
        Node mid = findMiddleNode(head);
        Node head1 = reverse(mid);
        Node head2 = head1;

        while (head != null && head1 != null) {
            if (head.value != head1.value) {
                break;
            }
            head = head.next;
            head1 = head1.next;
        }
        reverse(head2);

        return head == null || head1 == null;
    }

    public static Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }


    private static Node findMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
