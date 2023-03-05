package DoublyLinkedList_Files;

import DoublyLinkedList_Files.Node;

public class DoublyLinkedList {
    Node head = null;
    Node tail = null;

    public void addNodeFront(int val) {
        Node temp = new Node(val, head, null);
        if (head != null) {
            head.prev = temp;
        }
        head = temp;
        if (tail == null) {
            tail = temp;
        }
    }

    public void addNodeBack(int val) {
        Node temp = new Node(val, null, tail);
        if (tail != null) {
            tail.next = temp;
        }
        tail = temp;
        if (head == null) {
            head = temp;
        }
    }

    public int removeNodeFront() {
        Node temp = head;
        head = head.next;
        head.prev = null;
        return temp.data;
    }

    public int removeNodeBack() {
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        return temp.data;
    }

    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.data + " <- ");
            temp = temp.prev;
        }
        System.out.println("END");
    }

    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}

