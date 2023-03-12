package Day_3;

import Node.ListNode;
import Node.TreeNode;

public class LinkedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = findMiddleNode(head);
        TreeNode root = new TreeNode(mid.val);
        if (head == mid) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMiddleNode(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        ListNode prev = node;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}
