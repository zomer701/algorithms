package aws;

import java.util.Stack;

public class Leetcode_1910 {
    public static void main(String[] args) {
        //da abc bc abc bc

       // abc

        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

    public static String removeOccurrences(String s, String part) {
        if (s.length() < part.length()) {
            return s;
        }

        if (s.length() == 0 ||  part.length() == 0) {
            return s;
        }
        while (s.contains(part)) {
            int index = s.indexOf(part);
            int len = s.length();
            s = s.substring(0, index) + s.substring(index+part.length(), len);
        }

        return s;
    }
}
