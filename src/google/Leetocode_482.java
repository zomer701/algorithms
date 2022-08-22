package google;

import java.util.Locale;

public class Leetocode_482 {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 2));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder data = new StringBuilder();

        String withoutDash = s.replaceAll("-", "").toUpperCase(Locale.ROOT);
        int leng = withoutDash.length();
        if (leng < k) {
            return withoutDash;
        }

        int mode = leng % k;
        if (mode > 0) {
            data.append(withoutDash.substring(0, mode)).append("-");
        }

        int integerVal = (leng-mode)/k;
        int sub = mode;
        for (int i = 1; i <= integerVal; i++) {
            data.append(withoutDash, sub, sub+k);
            sub += k;

            if (i != integerVal) {
                data.append("-");
            }
        }

        return data.toString();
    }
}
