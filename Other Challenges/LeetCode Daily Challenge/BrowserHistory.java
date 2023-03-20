package org.weeklydsa.Daily_Challenges;

public class BrowserHistory {
    private final Node head;
    private Node tail;
    private Node currPage;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        tail = head;
        currPage = head;
    }

    public void visit(String url) {
        Node node = new Node(url);
        currPage.next = node;
        node.prev = currPage;
        tail = node;
        currPage = node;
    }

    public String back(int steps) {
        while(steps-- > 0){
            if(currPage == head){
                return currPage.pageName;
            }
            currPage = currPage.prev;
        }
        return currPage.pageName;
    }

    public String forward(int steps) {
        while(steps-- > 0){
            if(currPage == tail){
                return currPage.pageName;
            }
            currPage = currPage.next;
        }
        return currPage.pageName;
    }
}

class Node {
    public String pageName;
    public Node prev;
    public Node next;

    public Node(){}

    public Node(String pageName) {
        this.pageName = pageName;
    }
}
