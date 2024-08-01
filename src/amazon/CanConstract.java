package amazon;

import java.util.List;

public class CanConstract {
    public static void main(String[] args) {
        System.out.print(execute("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }

    private static boolean execute(String value, List<String> dictionary) {
        boolean [] memo = new boolean[value.length()+1];
        memo[0] = true;
        for (int i = 0; i<=value.length();i ++) {
            if (memo[i]) {
                for (String word: dictionary) {
                    if (value.substring(i).startsWith(word)) {
                        memo[i+word.length()] = true;
                    }
                }
            }
        }


        return memo[value.length()];
    }
}
