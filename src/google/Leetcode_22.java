package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_22 {
    public static void main(String[] args) {
        generate(3);
    }
       // 1 () | )( | ( | )
       // 2 () () | (()) | )()) | ))(( | ())) |
    public static List<String> generate(int n) {
        List<String> data = new ArrayList<>();

        generateParenthesis(data, "", 0, 0, n);

        return data;
    }

    private static void generateParenthesis(List<String> result, String s, int open, int close, int n) {
        if (open == n && close == n) {
            result.add(s);
            return;
        }
        // If the number of open parentheses is less than the given n
        if (open < n) {
            generateParenthesis(result, s + "(", open + 1, close, n);
        }
        // If we need more close parentheses to balance
        if (close < open) {
            generateParenthesis(result, s + ")", open, close + 1, n);
        }
    }

    public static List<String> generate2(int nr) {
        List<String> data = new ArrayList<>();

        embrace(nr, nr, new char[nr * 2], 0, data);

        return data;
    }

    private static void embrace(int left, int right, char[] str, int index, List<String> result) {
        if (right < left || left < 0) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(String.valueOf(str));
        } else {
            str[index] = '{';
            embrace(left - 1, right, str, index+1, result);
            str[index] = '}';
            embrace(left, right-1, str, index+1, result);
        }
    }
}
