package aws;

public class Leetcode_2330 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_2330().makePalindrome("aa"));
    }

    public boolean makePalindrome(String s) {
        int miss = 0;
        int left = 0, right = s.length() - 1;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
                miss++;

            left++;
            right--;
        }
        return miss < 3;
    }
}
