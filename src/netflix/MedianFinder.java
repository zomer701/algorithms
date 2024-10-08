package netflix;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
       maxHeap.add(num);
       minHeap.add(maxHeap.poll());

       if (maxHeap.size() < minHeap.size()) {
           maxHeap.add(minHeap.poll());
       }
    }

    public double findMedian() {

        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5;
    }
}
