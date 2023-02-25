package Day_2;

import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        LL list = new LL();
        for (int i = 0; i < nums.length; i++) {
            list.insert(nums[i], i);
        }
        System.out.println("Before Removing");
        list.display();
        Node newHead = deleteDuplicates(list.getHead());
        System.out.println("After Removing");
        list.display();
    }
    public static Node deleteDuplicates(Node head) {
        Node h = head;
        while(h.next != null) {
            if(h.value == h.next.value) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
        return head;
    }
}
