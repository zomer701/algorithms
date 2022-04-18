import java.util.List;

public class StringToInteger
{
    public int myAtoi(String s) {

        char space = ' ';
        char plus = '+';
        char minus = '-';
        char zero = '0';
        int index = 0;
        int indicator = 1;

        List<Character> numbers = List.of(zero, '1', '2', '3', '4', '5', '6', '7', '8', '9');

        if (s == null || s.length() <= 0)
            return 0;

        while (index < s.length() && s.charAt(index) == space) {
            index++;
        }

        if (index >= s.length()) {
            return 0;
        }




        char point = s.charAt(index);

        if (point == minus) {
            index++;
            indicator = -1;
        } else if (point == plus) {
            index++;
        }

        long sum = 0L;
        while (index < s.length() && numbers.contains(s.charAt(index)))
        {
            sum = sum * 10 + (s.charAt(index) - '0');
            index++;

            if (sum > Integer.MAX_VALUE) {
                // if we passed max integer value, check the sign and return correct value
                return indicator > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return indicator * (int) sum;
    }
}
