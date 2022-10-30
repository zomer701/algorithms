package google;

import java.util.Arrays;

public class Leetcode_186 {
    public static void main(String[] args) {
        char[] data = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};

        new Leetcode_186().reverseWords(data);
        System.out.println(Arrays.toString(data));
    }
    public void reverseWords(char[] str) {
        int i = 0, j = str.length - 1;
        while (i < j) {
            swap(str, i, j);
            i++;
            j--;
        }


        int start = 0;
        for (int point = 0; point < str.length + 1; point++) {
            if (point == str.length || str[point] == ' ') {
                int innerStart = start;
                int innerEnd = point - 1;

                while (innerStart < innerEnd) {
                    swap(str, innerStart, innerEnd);
                    innerStart++;
                    innerEnd--;
                }

                start = point;
                start++;
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
