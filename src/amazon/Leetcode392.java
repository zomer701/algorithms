package amazon;

public class Leetcode392 {
    public static void main(String[] args) {
        System.out.print(isSub("asdasdasasdasd", "aps"));
    }

    static boolean isSub(String s, String t) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
                if (index == t.length()) {
                    return true;
                }
                if (s.charAt(i) == t.charAt(index)) {
                    index++;
                }
        }

        return index == t.length();
    }
}
