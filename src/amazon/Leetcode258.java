package amazon;

public class Leetcode258 {
    public static void main(String[] args) {
        System.out.print(addDigits(38));
    }

    public static int addDigits(int num) {
        int result = 1;

        int proceed  = num;
        while (proceed > 9) {
            proceed = split(proceed);
            result++;
        }

        return result;
    }

    private static int split (int splitNum) {
        int count = 1;
        while (splitNum > 9) {
            count += (splitNum % 10);
            splitNum /= splitNum;
        }

        return count == 1 ? splitNum : count;
    }
}
