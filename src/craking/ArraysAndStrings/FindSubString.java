package craking.ArraysAndStrings;

public class FindSubString {
    public static void main(String[] args) {
        System.out.println(new FindSubString().findMatch("dasdasdasdasda", "as"));
    }

    boolean findMatch(String l, String l2) {
        int lLen = l.length();
        int l2Len = l2.length();

        if (l2Len > lLen) {
            return false;
        }

        for (int i = 0; i < lLen-l2Len; i++) {
            int count = 0;
            if (l.charAt(i) == l2.charAt(count)) {
                while (count < l2Len && l.charAt(i+count) == l2.charAt(count)) {
                    if (count == l2Len-1) {
                        return true;
                    }

                    count++;
                }
            }
        }

        return false;
    }
}
