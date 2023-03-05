package DoublyLinkedList_Files;

public class Node {
    // stores data
    public int data;

    // pointer to the next node
    public Node next;

    // pointer to the previous node
    public Node prev;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
