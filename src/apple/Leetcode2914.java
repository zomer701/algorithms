package apple;

public class Leetcode2914 {

    public static void main(String[] args) {
        System.out.println(minChanges("0000"));
    }

    public static int minChanges(String s) {
        int count = 0;

        char prev = s.charAt(0);
        for (int i = 1 ; i < s.length(); i ++) {
            if ((i+1) % 2 == 0) {
                if (prev != s.charAt(i)) {
                    count++;
                }
            } else {
                prev = s.charAt(i);
            }
        }

        return count;
    }
}
