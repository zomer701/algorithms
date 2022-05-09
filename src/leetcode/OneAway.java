package leetcode;

public class OneAway {
    public static void main(String[] args) {
        System.out.println(new OneAway().isOneEditDistance("ab", "ba"));
    }

    public boolean isOneEditDistance(String s, String t) {
        // return false if two strings are equal or the length difference greater than one
        if (s.equals(t) || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int lenS = s.length();
        int lenT = t.length();
        for (int i = 0; i < Math.min(lenS, lenT); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (lenS == lenT) {
                    // do replace
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if (lenS < lenT) {
                    // do insert
                    return s.substring(i).equals(t.substring(i+1));
                } else {
                    // do delete
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        // all min(lenS, lenT) part are equal, one string must be longer than aother one by one character.
        return lenS != lenT;
    }
}
