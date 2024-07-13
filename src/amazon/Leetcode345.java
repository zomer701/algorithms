package amazon;

import java.util.Set;

public class Leetcode345 {

    static Set<Character> dataSet = Set.of('a', 'e', 'i', 'o','u', 'A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {
        System.out.print(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        int l = 0;
        int r = s.length()-1;

        char[] data = s.toCharArray();

        while (l < r) {
            char left = data[l];
            if (!dataSet.contains(left)) {
                l++;
                continue;
            }

            char right = data[r];
            if (!dataSet.contains(right)) {
                r--;
                continue;
            }

            char temp = data[l];
            data[l] = data[r];
            data[r] = temp;
            l++;
            r--;
        }

        return String.valueOf(data);
    }
}
