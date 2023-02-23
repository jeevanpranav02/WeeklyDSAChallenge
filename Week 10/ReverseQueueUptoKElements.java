package Day_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueUptoKElements {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] nums = {10,20,30,40,50,60,70,80,90,100};
		for(int n : nums) {
			queue.add(n);
		}
        int k = 5;
        System.out.println(modifyQueue(queue, k));
	}
	public static Queue<Integer> modifyQueue(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
        return queue;
    }
}
