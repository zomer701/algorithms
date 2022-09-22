package google;

import java.util.PriorityQueue;

public class Leetcode_703 {
    public static void main(String[] args) {
        int [] data = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, data);
        System.out.println(kthLargest.add(3));   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

    static class KthLargest {
        static PriorityQueue<Integer> pq;
        static int k;

        public KthLargest(int k, int[] nums) {
            KthLargest.k = k;
            pq = new PriorityQueue<>(k);
            for (int num: nums) {
                pq.add(num);
            }
        }

        public int add(int val) {
            if (pq.size() <  KthLargest.k) {
                pq.add(val);
                return pq.peek();
            }
            else if (pq.peek() < val)
            {
                pq.poll();
                pq.add(val);
            }

            if (pq.size() == k) {
                return pq.peek();
            }
            else {
                return -1;
            }
        }
    }
}
