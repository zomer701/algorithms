package meta;

public class Leetcode_415 {
    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
    }
    public static String addStrings(String num1, String num2) {
        var maxValue = Math.max(num1.length(), num2.length());

        var result = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < maxValue; i++) {
            if (i < num1.length() && i < num2.length()) {
                sum+=(num1.charAt(num1.length()-i-1) - '0') + (num2.charAt(num2.length()-i-1) -'0');
            } else if (i < num1.length()) {
                sum+=(num1.charAt(num1.length()-i-1) - '0');
            } else {
                sum+=(num2.charAt(num2.length()-i-1) - '0');
            }

            result.append(sum % 10);
            sum /= 10;
        }

        if (sum > 0) result.append(sum);

        return result.reverse().toString();
    }
}
