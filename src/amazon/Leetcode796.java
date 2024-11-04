package amazon;

public class Leetcode796 {
    public static void main(String[] args) {

    }

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }
}
