package amazon;

public class Leetcode67 {
    public static void main(String[] args) {
    }

   // 11
    //11
    //  0110

    //"1010",
    //"1011"
   // 10101
    public static String addBinary(String a, String b) {
        int aL = a.length()-1;
        int bL = b.length()-1;

        StringBuilder result = new StringBuilder();

        boolean pivot = false;
        while (aL >= 0 || bL  >= 0) {
            char aChar = aL > 0 ? a.charAt(--aL) : '0';
            char bChar = bL > 0 ? b.charAt(--bL) : '0';

            if (aChar == '0' && bChar == '0') {

                result.append(pivot ? '1' : '0');
                pivot = false;
                continue;
            }

            if (aChar == '1' && bChar == '1') {
                result.append(pivot ? '1' : '0');
                pivot = true;
                continue;
            }

            if (pivot) {
                result.append('0');
            } else  {
                result.append('1');
            }
        }

        if (pivot) {
            result.append('1');
        }

        return result.reverse().toString();
    }
}
