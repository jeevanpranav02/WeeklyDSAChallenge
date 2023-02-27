package Day_4;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        int n1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        LL list1 = new LL();
        for (int num : n1) {
            list1.insertLast(num);
        }
        int n2[] = {9, 8, 7, 6, 5, 4, 9, 9, 9, 0};
        LL list2 = new LL();
        for (int num : n2) {
            list2.insertLast(num);
        }
        System.out.println("List 1");
        list1.display();
        System.out.println("List 2");
        list2.display();
        LL resultList = new LL();
        resultList.setHead(addTwoNumbers(list1.getHead(), list2.getHead()));
        System.out.println("Added list");
        resultList.display();
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node listNode1 = reverseList(l1);
        Node listNode2 = reverseList(l2);
        Node resHead = null;
        Node n = null;
        int carry = 0;
        while (listNode1 != null || listNode2 != null) {
            int v1 = listNode1 != null ? listNode1.value : 0;
            int v2 = listNode2 != null ? listNode2.value : 0;
            int sum = v1 + v2 + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            n = new Node(sum);
            n.next = resHead;
            resHead = n;
            if (listNode1 != null) {
                listNode1 = listNode1.next;
            }
            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
        }
        if (carry >= 1) {
            Node temp = new Node(1);
            temp.next = resHead;
            resHead = temp;
        }
        return resHead;
    }

    private static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
