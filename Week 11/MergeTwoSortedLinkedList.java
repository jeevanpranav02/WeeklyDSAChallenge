package Day_2;

import LinkedList_Files.LL;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 3, 4};
        LL list1 = new LL();
        LL list2 = new LL();
        for (int i = 0; i < nums1.length; i++) {
            list1.insert(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            list2.insert(nums2[i], i);
        }
        System.out.println("Before merging");
        list1.display();
        list2.display();
        LL list = mergeTwoLists(list1, list2);
        System.out.println("After merging");
        list.display();
    }

    private static LL mergeTwoLists(LL head1, LL head2) {
        LL.Node f = head1.getHead();
        LL.Node s = head2.getHead();

        LL result = new LL();

        while(f != null && s != null) {
            if(f.value <= s.value) {
                result.insertLast(f.value);
                f = f.next;
            } else {
                result.insertLast(s.value);
                s = s.next;
            }
        }

        while(f != null) {
            result.insertLast(f.value);
            f = f.next;
        }

        while(s != null) {
            result.insertLast(s.value);
            s = s.next;
        }
        return result;
    }
}
