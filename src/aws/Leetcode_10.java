package aws;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode_10 {
    public static void main(String[] args) {
//        System.out.println(1 + " " + (isMatch("aa","a") != false ? "ISSUE" : "OK"));
//        System.out.println(2 + " " + (isMatch("aaa","aa") != false ? "ISSUE" : "OK"));
//        System.out.println(3 + " " + (isMatch("aa","aaa") != false ? "ISSUE" : "OK"));
//        System.out.println(4 + " " + (isMatch("aa","aa") != true ? "ISSUE" : "OK"));
//        System.out.println(5 + " " + (isMatch("asdqweqwedasdadasd","asdqweqwedasdadasd") != true ? "ISSUE" : "OK"));
//        System.out.println(6 + " " + (isMatch("aa", "a.") != true ? "ISSUE" : "OK"));
//        System.out.println(7 + " " + (isMatch("aa", "..") != true ? "ISSUE" : "OK")); //
//       System.out.println(8 + " " + (isMatch("ab", ".b") != true ? "ISSUE" : "OK"));
//        System.out.println(9 + " " + (isMatch("bb", "..") != true ? "ISSUE" : "OK")); //
//        System.out.println(10 + " " + (isMatch("bb", "..b") != false ? "ISSUE" : "OK"));
//        System.out.println(11 + " " + (isMatch("ab", ".ab") != false ? "ISSUE" : "OK"));
        System.out.println(12 + " " + (isMatch("ab", "c.") != false ? "ISSUE" : "OK"));

//        System.out.println(13 + " " + (isMatch("aa", "a*") != true ? "ISSUE" : 1));
//        System.out.println(14 + " " + (isMatch("aa", ".*") != true ? "ISSUE" : 1));
//        System.out.println(15 + " " + (isMatch("ab", ".*") != true ? "ISSUE" : 1));
//        System.out.println(16 + " " + (isMatch("aab", "c*a*b") != true ? "ISSUE" : 1));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }

        if (s == null || p == null) {
            return false;
        }

        int sL = s.length() - 1;
        int pL = p.length() - 1;

        if (pL > sL) {
            return false;
        }

        int countP = 0;
        int countS = 0;
        Queue<Character> process = new LinkedList<>();
        process.add(p.charAt(countP++));

        boolean stack = false;
        while (!process.isEmpty()) {
            if (countS == sL+1) {
                return true;
            }

            var current = stack ? process.peek() : process.poll();
            if (current == '*') {
                if (countP > pL) {
                    return false;
                }
                process.add(p.charAt(countP++));
                stack = true;
            }

            var checkVal = s.charAt(countS++);
            if (current != checkVal || current != '.') {
                if (stack) {
                    return false;
                }
            } else {
                stack = false;
            }

            if (countP <= pL) {
                process.add(p.charAt(countP++));
            }

        }

        return countS == sL+1;
    }
}
