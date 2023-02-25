package Day_2;
import LinkedList_Files.LL;
import LinkedList_Files.LL.Node;

public class FindLengthOfLoop {
    public static void main(String[] args) {
        int[] nums = {25, 14, 19, 33, 10, 21, 39, 90, 58, 45};
        LL list = new LL();
        for(int i = 0; i < nums.length; i++) {
            list.insert(nums[i], i);
        }
        list = list.makeloop(list, 4);
        System.out.println(countNodesInLoop(list.getHead()));
    }

    static int countNodes(Node node) {
        int count = 1;
        Node temp = node;
        while (temp.next != node) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static int countNodesInLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return countNodes(slow);
        }
        return 0;
    }
}


