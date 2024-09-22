package tiktok;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode17 {

//    Input: digits = "23"
//    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// abc
// def
    static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");



    public static List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return combinations;
        }

        backtrack(digits, new StringBuilder(), combinations, 0);

        return combinations;
    }

    private static void backtrack(String digits, StringBuilder pros, List<String> combinations, int index) {
        if (digits.length() == pros.length()) {
            combinations.add(pros.toString());
            return;
        }


        String possibleLetters = letters.get(digits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            pros.append(letter);
            backtrack(digits, pros, combinations, index+1);
            pros.deleteCharAt(pros.length()-1);
        }

    }
}
