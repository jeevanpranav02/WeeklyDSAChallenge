package Day_4;

import java.util.LinkedList;

class FrontMiddleBackQueue {
    LinkedList<Integer> list;
    public FrontMiddleBackQueue() {
        list = new LinkedList<Integer>();
    }
    
    public void pushFront(int val) {
        list.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        int size = list.size();
        size = size >> 1;
        list.add(size, val);
    }
    
    public void pushBack(int val) {
        list.addLast(val);
    }
    
    public int popFront() {
        if(list.isEmpty()) {
            return -1;
        }
        return list.pollFirst();
    }
    
    public int popMiddle() {
        if(list.isEmpty()) {
            return -1;
        }
        int size = list.size() - 1;
        size = size >> 1;
        int v = list.get(size);
        list.remove(size);
        return v;
    }
    
    public int popBack() {
        if(list.isEmpty()) {
            return -1;
        }
        return list.pollLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */