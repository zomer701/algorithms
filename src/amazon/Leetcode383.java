package amazon;

public class Leetcode383 {
    public static void main(String[] args) {
        System.out.print(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        return helper(0, ransomNote, magazine);
    }

    static boolean helper(int index, String ransomNote, String magazine) {
        if (index == ransomNote.length()) {
            return true;
        }


        int indexChar = magazine.indexOf(ransomNote.charAt(index));
        if (indexChar == -1) {
            return false;
        }

        magazine = magazine.substring(0, indexChar) + magazine.substring(indexChar+1, magazine.length());


        index++;
        return helper(index, ransomNote, magazine);
    }
}
