package Day_1;

public class DetectRotation {
    public static void main(String[] args) {
        int[] nums = {3,2,0,-4};
        LinkedList list = new LinkedList();
        ListNode node = list.createList(nums);
        node = list.makeCycle(node, 1);
        System.out.println(hasCycle(node));
        System.out.println(detectCycle(node).value + " " + detectCycle(node));
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
    public static boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int value;
    ListNode next;
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    ListNode head = null;
    ListNode tail = null;

    LinkedList() {}

    public ListNode createList(int[] nums) {
        for (int num : nums) {
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    public ListNode makeCycle(ListNode head, int index) {
        ListNode node = head;
        while(node != null && index-- > 0) {
            node = node.next;
        }
        tail.next = node;
        return head;
    }
}
