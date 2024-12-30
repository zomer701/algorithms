package amazon;

public class Leetcode520 {
    public static void main(String[] args) {
        System.out.print(detectCapitalUse("FlaG"));
    }

    public static boolean detectCapitalUse2(String word) {
        String s = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
        return  word.toLowerCase().equals(word) ||    word.toUpperCase().equals(word) ||word.equals(s);
    }

    public static boolean detectCapitalUse(String word) {
        boolean islower = Character.isLowerCase(word.charAt(0));
        boolean isAllUpper = false;

        for (int i = 1 ; i < word.length(); i++) {
            char current = word.charAt(i);

            if (islower && Character.isUpperCase(current)) {
                return false;
            }

            if (i == 1 && Character.isUpperCase(current)) {
                isAllUpper = true;
                continue;
            }

            if (isAllUpper && Character.isLowerCase(current)) {
                return false;
            }

            if (!isAllUpper && Character.isUpperCase(current)) {
                return false;
            }
        }

        return true;
    }
}
