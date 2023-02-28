package Day_5;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        LL list = new LL();
        for (int num : nums) {
            list.insertLast(num);
        }
        list.display();
        list.setHead(deleteMiddle(list.getHead()));
        list.display();
    }
    public static Node deleteMiddle(Node head) {
        if(head.next == null){
            return null;
        }
        Node fast = head;
        Node slow = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
