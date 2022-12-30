package aws;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode_1823 {
    public static void main(String[] args) {
       // System.out.println(new Leetcode_1823().findTheWinner());
    }

//Trying to identify a pattern or a recursive call can be done based on the following observations.
   // After the first man (kth) is eliminated, n-1 men are left.
   // This means that we call josephus(n – 1, k) to get the position of the n-1th man.
   // However, notice that the position returned by josephus(n – 1, k) will take into account the position starting from k%n + 1.
   // In other words, we have to adjust the position returned by josephus(n – 1, k)
   // to obtain (josephus(n - 1, k) + k - 1) % n + 1. The recursive method is shown here:”

//    public int findTheWinner(int n, int k) {
//        if (n == 1) {
//            return 1;
//        }
//
//        return (findTheWinner(n - 1, k) + k - 1)  % n + 1 ;
//    }

    public int findTheWinner(int n, int k) {
        Queue<Integer> circle = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        while (circle.size() != 1) {
            for (int i = 1; i <= k; i++) {
                int el = circle.poll();
                if (i == k) {
                    break;
                }

                circle.add(el);
            }
        }

        return circle.peek();
    }

}
