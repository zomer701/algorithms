package leetcode;

import java.util.ArrayList;
import java.util.List;

//comples 2^n  space n
public class String_Subsequence {
    public static void main(String[] args) {

        System.out.println(String.join(",", subsequence("abc", new ArrayList<>())));
    }

    static List<String> subsequence(String word, List<String> data) {
        if (word.length() == 0) {
            data.add("");
            return data;
        }

        char first = word.charAt(0);
        List<String> rest = subsequence(word.substring(1), data);

        List<String> withFirst = new ArrayList<>();

        for (String value: rest) {
            withFirst.add(first + value);
        }

        withFirst.addAll(rest);
        return withFirst;
    }
}
