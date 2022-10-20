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
        System.out.println(s);
        // Base case
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
}
