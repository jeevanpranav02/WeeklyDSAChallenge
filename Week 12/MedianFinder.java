package Day_5;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder{
    private Queue<Double> queueMin;
    private Queue<Double> queueMax;
    private boolean even = true;
    public void MedianFinder() {
        queueMin = new PriorityQueue<>();
        queueMax = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (even) {
            queueMin.offer((double) num);
            queueMax.offer(queueMin.poll());
        } else {
            queueMax.offer((double) num);
            queueMin.offer(queueMax.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (queueMax.peek() + queueMin.peek()) / 2.0;
        } else {
            return queueMax.peek();
        }
    }
}