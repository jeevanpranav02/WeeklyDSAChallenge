package Day_6;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class SegregateOneTwoZero {
    public static void main(String[] args) {
        int nums[] = {0, 2, 1, 2, 0, 1, 0, 1, 0, 2, 2, 2, 1, 2};
        LL list = new LL();
        for (int num : nums) {
            list.insertLast(num);
        }
        list.display();
        list.setHead(segregate(list.getHead()));
        list.display();
    }

    private static Node segregate(Node head) {
        int[] count = {0, 0, 0};
        Node current = head;
        while (current != null) {
            count[current.value]++;
            current = current.next;
        }
        current = head;
        int i = 0;
        while (current != null) {
            if (count[i] == 0) {
                i++;
            } else {
                current.value = i;
                count[i]--;
                current = current.next;
            }
        }
        return head;
    }
}
