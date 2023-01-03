package aws;

public class Leetcode_392 {
    public static void main(String[] args) {
        String a = "b";
        String b = "abc";
        System.out.println(new Leetcode_392().isSubsequence(a, b));
    }


    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }

        if (s.length() == 0) {
            return true;
        }

        if (s.length() > t.length()) {
            return false;
        }

        int check = 0;

        for (int i = 0; i < t.length(); i++ ) {
            if (check == s.length()) {
                return true;
            }

            if (t.charAt(i) == s.charAt(check)) {
                check++;
            }
        }

        return check == s.length();
    }
}
