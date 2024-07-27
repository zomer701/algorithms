package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Leetcode17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("233"));
    }

    static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");



    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        String firstCharArray = letters.getOrDefault(digits.charAt(0), "");
        for (char val: firstCharArray.toCharArray()) {
            combinations.add(String.valueOf(val));
        }


        if (digits.length() == 1) {
            return combinations;
        }

        for (int i = 1; i < digits.length(); i++) {
            List<String> prevCombinations = new ArrayList<>(combinations);
            combinations.clear();
            String possibleLetters = letters.get(digits.charAt(i));
            for (char current: possibleLetters.toCharArray()) {
                for (String prev: prevCombinations) {
                    combinations.add(prev + current);
                }
            }
        }





        return combinations;
    }
}
