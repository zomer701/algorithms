package aws;

public class Leetcode_67 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_67().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int aL = a.length();
        int bL = b.length();

        StringBuilder result = new StringBuilder();

        boolean pivot = false;

        while(aL > 0 || bL > 0) {
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
