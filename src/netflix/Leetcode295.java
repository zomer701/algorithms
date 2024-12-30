package netflix;

public class Leetcode295 {

    public static void main(String[] args) {
        //["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//     [[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
//[null,null,-1.00000,null,-1.00000,null,-2.00000,null,-2.00000,null,-3.00000]
//[null,null,-1.00000,null,-1.50000,null,-2.00000,null,-2.50000,null,-3.00000]
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
    }

}
