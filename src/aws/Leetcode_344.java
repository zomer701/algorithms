package aws;

import java.util.Arrays;

public class Leetcode_344 {
    public static void main(String[] args) {
        char [] data = {'h','e','l','l','o'};
        new Leetcode_344().reverseString(data);

        System.out.println(Arrays.toString(data));
    }

    public void reverseString(char[] s) {
        for (int i = s.length; i > s.length/2; i--) {
            char temp = s[i - 1];
            s[i-1] = s[s.length  - i ];
            s[s.length  - i] = temp;
        }
    }
}
