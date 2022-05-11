package leetcode;

public class RotateString {
    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcde", "cdeab"));
    }

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
