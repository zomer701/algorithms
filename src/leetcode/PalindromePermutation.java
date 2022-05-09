package leetcode;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(new PalindromePermutation().canPermutePalindrome("aabg"));
    }

    public boolean canPermutePalindrome(String s) {
        int[] data = new int[128];

        for (char v: s.toCharArray()) {
            data[v]++;
        }

        int count = 0;
        for (int v: data) {
            count +=  v % 2;
        }

        return count <= 1;
    }
}
