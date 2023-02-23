package Day_6;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Node head = new Node();
	Node tail = new Node();
	Map<Integer, Node> map = new HashMap<>();
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			insert(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (map.size() == capacity) {
			remove(tail.prev);
		}
		insert(new Node(key, value));
	}

	private void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
		node.prev = head;
	}
}

class Node {
	Node prev, next;
	int key, value;

	Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
	Node() {
		this(0, 0);
	}
}