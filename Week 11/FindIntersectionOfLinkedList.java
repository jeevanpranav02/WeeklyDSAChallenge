package Day_6;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

import java.util.HashMap;
import java.util.Map;

public class FindIntersectionOfLinkedList {
    public static void main(String[] args) {
        int nums[] = {1, 2, 4, 5, 6};
        LL list = new LL();
        for (int num : nums) {
            list.insertLast(num);
        }
        LL list2 = new LL();
        list2.insertLast(10);
        list2.insertLast(20);
        list2.getTail().next = list.getNode(4);
        System.out.println("List 1");
        list.display();
        System.out.println("List 2");
        list2.display();
        System.out.println("The intersection node is " + getIntersectionNode(list.getHead(), list2.getHead()).value);
    }

    public static Node getIntersectionNode(Node head1, Node head2) {
        Map<Node, Integer> map = new HashMap<>();
        while (head1 != null) {
            map.put(head1, head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (map.containsKey(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }
}
