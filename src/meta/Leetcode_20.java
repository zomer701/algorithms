package meta;

import java.util.Map;
import java.util.Stack;

public class Leetcode_20 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_20().isValid("[])"));
    }

    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        var keys = Map.of(')', '(', ']', '[', '}', '{');
        int countOpen = 0;
        int countClose = 0;

        int count = 0;

        while (count < s.length()) {
            if (keys.containsKey(s.charAt(count))) {

                var value = keys.get(s.charAt(count));
                int innerCount = count - 1;
                if (innerCount < 0) {
                    return false;
                }
                while (innerCount >= 0) {
                    if (s.charAt(innerCount) == '_') {
                        innerCount--;
                        if (innerCount < 0) {
                            return false;
                        }
                        continue;
                    }

                    if (s.charAt(innerCount) == value) {
                        StringBuilder string = new StringBuilder(s);
                        string.setCharAt(innerCount, '_');
                        string.setCharAt(count, '_');
                        s = string.toString();
                        countClose++;
                        break;
                    } else {
                        return false;
                    }
                }
            } else {
                countOpen++;
            }

            count++;
        }

        return countOpen == countClose;
    }
}
