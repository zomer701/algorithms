package google;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_509 {
    public static void main(String[] args) {

        System.out.println(fib(6));
    }

    public static int fib(int n) {

       if (n <= 1) {
           return n;
       }

       int first = 1;
       int second = 0;
       int result = 0;

        for (int i = 1; i < n ; i++) {
            result = first + second;
            second = first;
            first = result;
       }

        return result;
    }
}
