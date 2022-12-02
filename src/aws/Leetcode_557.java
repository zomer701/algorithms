package aws;

public class Leetcode_557 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_557().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        int count = 0;

        char[] data = s.toCharArray();
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && count > 0) {
                revert(i-count,i-1, data);
                count = 0;
            } else {
                count++;
            }


        }

        if (count > 0) {
            revert(data.length-count,data.length-1, data);
        }
       return toString(data);
    }

    public static String toString(char[] a)
    {
        // Creating object of String class
        StringBuilder sb = new StringBuilder();

        // Creating a string using append() method
        for (char c : a) {
            sb.append(c);
        }

        return sb.toString();
    }
    void revert(int start, int end, char[] data) {

        while (start < end) {
            swap(data, start, end);
            start++;
            end--;
        }
    }

    public void swap(char[] nums, int a, int b) {
        char temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
