package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Leetcode_17 {
    Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public static void main(String[] args) {


        System.out.println(Arrays.toString( new Leetcode_17().letterCombinations("23").toArray()));
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        back("", digits, combinations, digits.length(), 0);

        return combinations;
    }

    public void back(String value, String digits, List<String> result, int initLenght, int lenght) {
            if (value.length() == initLenght) {
                result.add(value);
                return;
            }

        String possibleLetters = letters.get(digits.charAt(lenght));

        for (Character dig: possibleLetters.toCharArray()) {
            String newLvalue = value+dig;
            back(newLvalue, digits, result, initLenght, lenght + 1);
            newLvalue.substring(0, newLvalue.length()-1);
        }
    }
}
