package aws;

import java.util.Arrays;

public class Leetcode_151 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_151().reverseWords("  hello world  "));
    }
    public String reverseWords(String s) {

        int start = 0;
        int end = s.length() - 1;
        char [] data = s.toCharArray();
        revert(start, end, data);

        int count = 0;
        for (int i = 0; i<data.length; i++) {
            if (data[i] != ' ')  {
                count++;
            } else {
                if (count > 0) {
                    revert(i-count, i-1, data);
                    count = 0;
                }
            }
        }

        if (count > 0) {
            revert(data.length-count, data.length-1, data);

        }

        int countV = 0;
        boolean space = false;
        for (int i = 0; i<data.length; i++) {
            if (data[i] == ' ') {
                if (space && i+1 != data.length) {
                    data[countV++] = ' ';
                    space = false;
                }
            } else {
                if (countV != i) {
                    data[countV++] = data[i];
                    space = true;
                } else {
                    countV++;
                    space = true;
                }
            }

        }

            StringBuilder ddd = new StringBuilder();
            for (int i = 0; i < countV ; i++) {
                ddd.append(data[i]);
            }

            return ddd.toString();
    }

    void revert(int start, int end, char[] data) {

        while (start < end) {
            swap(data, start, end);
            start++;
            end--;
        }
    }

        public void swap(char[] nums, int a, int b) {

            char temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
}
