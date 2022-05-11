package leetcode;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        char[] data = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(new StringCompression().compress(data));
    }

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        if (chars.length == 1) {
            return 1;
        }

        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count++;
            if (i + 1>= chars.length || chars[i] != chars[i+1]) {
                if (count > 0) {
                    result.append(chars[i]);
                    if (count > 1) {
                        result.append(count);
                    }

                    count = 0;
                }
            }
        }

        int countData = 0;
      //  chars = new char[result.length()];
        for (char data: result.toString().toCharArray()) {
            chars[countData++] = data;
        }

        System.out.println(Arrays.toString(chars));
        return result.length();
    }
}
