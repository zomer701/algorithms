package craking.ArraysAndStrings;

//Check Permutation: Given two strings,write a method to decide if one is a permutation of the
//        other.

import java.util.Arrays;
import java.util.List;

public class CheckPermutation
{
    public static void main(String[] args) {
    }

    public boolean permute(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] data2 = str2.toCharArray();
        char[] data1 = str1.toCharArray();

        Arrays.sort(data1);
        Arrays.sort(data2);

        return new String(data1).equals(new String(data2));
    }
}
