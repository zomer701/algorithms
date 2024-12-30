package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_43 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        int num1L = num1.length()-1;
        int num2L = num2.length()-1;


        if (num2.charAt(0) == '0' || num1.charAt(0) == '0') {
            return String.valueOf(0);
        }

        HashMap<Integer, Integer> memo = new HashMap<>();
        int carry = 0;
        for(int i = num1L ; i >= 0; i--) {
            int value = num1L-i;
            for (int j = num2L ; j >= 0; j--) {
                int num1V = num1.charAt(i) - '0';
                int num2V = num2.charAt(j) - '0';
                int innerMultiply = (num1V * num2V) +  memo.getOrDefault(value, 0)  + carry;
                memo.put(value++, innerMultiply % 10);
                carry = innerMultiply/10;
                if (j == 0 && carry != 0) {
                    memo.put(value++, carry);
                    carry = 0;
                }

            }
        }

        StringBuilder data = new StringBuilder();
        reverse(memo, data);

        return data.toString();
    }

    private static void reverse(Map<Integer, Integer> nums, StringBuilder data) {
        int i = 0, j = nums.size()-1;
        while (i <= j) {
            data.append(nums.get(j));
            j--;
        }
    }
}
