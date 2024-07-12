package amazon;

import java.util.Locale;

public class Leetcode482 {
    public static void main(String[] args) {
        System.out.print(licenseKeyFormatting("2-5g-3-J", 2));
    }

    public static String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "");
        int n = s.length();
        if (n <= k) {
            return s.toUpperCase();
        }

        StringBuilder data = new StringBuilder();
        while (n >= k) {
            StringBuilder data3 = new StringBuilder();
            data3.append(s, n-k, n);
            data.append(data3.reverse());

            n=n-k;
            if (n > 0) {
                data.append("-");
            }
        }

        StringBuilder data3 = new StringBuilder();
        data3.append(s, 0, n);
        data.append(data3.reverse());

        return data.reverse().toString().toUpperCase();
    }
}
