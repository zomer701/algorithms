package aws;

public class Leetcode_1047 {
    public static void main(String[] args) {
        String str = "aaaaaaaa";

        System.out.println(new Leetcode_1047().removeDuplicates(str));
    }


    public String removeDuplicates(String s) {
        char[] sChars = s.toCharArray();
        int sLength = s.length();

        if (sLength == 1) {
            return s;
        }

        int flag1 = 0;
        int flag2 = 0;

        while (flag1 < sLength) {
            while (flag2 > 0 && flag1 < sLength && sChars[flag1] == sChars[flag2 - 1]) {
                flag2--;
                flag1++;
            }

            if (flag1 < sLength) {
                sChars[flag2++] = sChars[flag1++];
            }
        }

        return new String(sChars).substring(0, flag2);
    }

}
