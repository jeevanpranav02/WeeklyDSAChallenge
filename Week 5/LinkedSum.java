package Day_6;

import javax.sound.midi.Soundbank;

public class LinkedSum {
    public static void main(String[] args) {
        ListNode root1 = new ListNode(2);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(3);
        ListNode root2 = new ListNode(5);
        root2.next = new ListNode(6);
        root2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(root1, root2));
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = new ListNode(0);
        ListNode cursor = firstNode;
        int remainder = 0;
        while (l1 != null || l2 != null) {
            int l1Num = (l1 != null) ? l1.val : 0;
            int l2Num = (l2 != null) ? l2.val : 0;
            int sum = l1Num + l2Num + remainder;
            remainder = sum / 10;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (remainder > 0) {
            cursor.next = new ListNode(remainder);
        }
        return firstNode.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}