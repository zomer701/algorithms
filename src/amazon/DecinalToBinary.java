package amazon;

public class DecinalToBinary {

    public static void main(String[] args) {
        System.out.print(findBinary(277, ""));
    }

    static String findBinary(int decimal, String result) {
        if (decimal == 0) {
            return  "";
        }

        result = decimal % 2 + result;
        return findBinary(decimal/2, result);
    }
}
