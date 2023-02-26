package Day_3;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int left = 3;
        int right = 7;
        LL list = new LL();
        for(int num:nums) {
            list.insertLast(num);
        }
        System.out.println("Before reversing");
        list.display();
        Node resHead = reverseBetween(list.getHead(),left,right);
        LL resList = new LL();
        resList.setHead(resHead);
        resList.display();
    }
    public static Node reverseBetween(Node head, int left, int right) {
        if(left == right) {
            return head;
        }
        Node prev = null;
        Node current = head;
        for(int i = 0;current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }
        Node last = prev;
        Node newEnd = current;
        Node next = current.next;
        for(int i = 0;current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null) {
                next = next.next;
            }
        }
        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
}
