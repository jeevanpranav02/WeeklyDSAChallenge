package Day_6;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class AddOneToLinkedList {
    public static void main(String[] args) {
        int nums[] = {9, 9, 9, 9, 9, 9, 9, 9, 9};
        LL list = new LL();
        for (int num : nums) {
            list.insertLast(num);
        }
        list.display();
        list.setHead(addOne(list.getHead()));
        list.display();
    }
    public static Node addOne(Node head) {
        head = reverse(head);
        head = addOneUtil(head);
        head = reverse(head);
        return head;
    }
    private static Node addOneUtil(Node head) {
        Node res = head;
        Node tail = null;
        Node prev = null;

        int carry = 1;
        int sum;

        while (head != null)
        {
            sum = carry + head.value;
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            head.value = sum;
            tail = head;
            head = head.next;
        }
        if (carry > 0) {
            tail.next = new Node(carry);
        }
        return res;
    }
    private static Node reverse(Node head) {
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
        return head;
    }
}
