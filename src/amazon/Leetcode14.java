package amazon;

public class Leetcode14 {
    public static void main(String[] args) {
        String[] strs = {"cir","car"};
        System.out.print(longestCommonPrefix(strs));
    }

    public static   String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }


        String f = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            int ncurrent = current.length();
            int nf = f.length();

            int index = 0;
            int same = 0;
            while (index < Math.min(nf, ncurrent)) {
                if (current.charAt(index) == f.charAt(index)) {
                    same++;
                    index++;
                } else {
                    break;
                }
            }

            if (same == 0) {
                return "";
            } else {
                f= f.substring(0, same);
            }

        }


        return f;
    }
}
