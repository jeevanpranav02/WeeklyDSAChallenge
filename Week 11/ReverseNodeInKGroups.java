package Day_7;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class ReverseNodeInKGroups {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LL list = new LL();
        for (int i = 0; i < nums.length; i++) {
            list.insert(nums[i], i);
        }
        System.out.println("Before reversing");
        list.display();
        Node newHead = reverseKGroup(list.getHead(), 4);
        System.out.println("After reversing");
        list.setHead(newHead);
        list.display();
    }
    public static Node reverseKGroup(Node head, int k) {
        if(k <= 1 || head == null) {
            return head;
        }
        Node curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        count = count - (count % k);
        Node current = head;
        Node prev = null;
        int currCount = 0;
        while(true) {
            Node last = prev;
            Node newEnd = current;
            Node next = current.next;
            for(int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if(next != null) {
                    next = next.next;
                }
                currCount++;
            }
            if(last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;
            if(current == null || currCount == count) {
                break;
            }

            prev = newEnd;
        }
        return head;
    }
}
