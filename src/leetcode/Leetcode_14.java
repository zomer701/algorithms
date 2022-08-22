package leetcode;

public class Leetcode_14 {
    public static void main(String[] args) {
        String[] strs = {"dog","dog","do"};

        System.out.println(new Leetcode_14()
                .longestCommonPrefix(strs));
    }

        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }

            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {
                String word2 = strs[i];

                prefix = getLongestPrefix(prefix, word2);

                if (prefix.isEmpty()) {
                    return "";
                }
            }

            return prefix;
        }

        private String getLongestPrefix(String string1, String string2) {
            StringBuilder prefix = new StringBuilder();

            int count = 0;

            while (string1.length() > count && string2.length() > count) {
                char val = string1.charAt(count);

                if (val != string2.charAt(count)) {
                    return prefix.toString();
                }

                prefix.append(val);
                count++;
            }

            return prefix.toString();
        }
}
