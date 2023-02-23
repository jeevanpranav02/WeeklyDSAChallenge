package Day_7;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private Map<Integer, Node> cache;
    private Map<Integer, DoublyLinkedList> frequencyMap;
    private int capacity, currentSize = 0, minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {  
            return -1;
        }
        updateNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;            
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateNode(node);
        } else {
            currentSize++;
            if (currentSize > capacity) {  
                DoublyLinkedList minFreqList = frequencyMap.get(minFreq);
                Node LRU_Node = minFreqList.tail.prev;
                cache.remove(LRU_Node.key);
                minFreqList.removeNode(LRU_Node);
                currentSize--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            DoublyLinkedList minFreqList = frequencyMap.getOrDefault(1, new DoublyLinkedList());
            minFreqList.addNode(newNode);
            frequencyMap.put(1, minFreqList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(Node node) {
        int currFreq = node.freq;
        DoublyLinkedList currList = frequencyMap.get(currFreq); 
        currList.removeNode(node);
        if (currFreq == minFreq && currList.size == 0) {
            minFreq++;  
        }

        node.freq++;
        DoublyLinkedList newList = frequencyMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addNode(node);
        frequencyMap.put(node.freq, newList);
    }
}

class Node {
    int key, value, freq;
    Node next, prev;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList {
    int size;
    Node head, tail;    
    DoublyLinkedList() {
        this.size = 0;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node node) {
        Node tempNode = head.next;
        head.next = node;
        node.next = tempNode;
        tempNode.prev = node;
        node.prev = head;
        size++;    
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--; 
    }
}