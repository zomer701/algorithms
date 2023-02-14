package aws;

public class Leetcode_43 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        int value = 0;
        int procent = 1;
        for (int i = num2.length()-1; i>=0; i--) {
            value += getMultiplyValue(num1, Integer.parseInt(String.valueOf(num2.charAt(i)))) * procent;
            procent = procent*10;
        }

        return String.valueOf(value);
    }

    private static int getMultiplyValue(String num1, int n) {
        int num1L = num1.length();
        int pivot = 0;

        StringBuilder builder = new StringBuilder();
        while (num1L-- > 0) {
            int val = pivot + Integer.parseInt(String.valueOf(num1.charAt(num1L)))*n;
            int less = val % 10;
            pivot = val / 10;
            builder.append(less);
        }

        if (pivot > 0) {
            builder.append(pivot);
        }

        return Integer.parseInt(builder.reverse().toString());
    }

//    public String multiply(String num1, String num2) {
//        int m = num1.length(), n = num2.length();
//        int[] pos = new int[m + n];
//
//        for(int i = m - 1; i >= 0; i--) {
//            for(int j = n - 1; j >= 0; j--) {
//                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//                int p1 = i + j, p2 = i + j + 1;
//                int sum = mul + pos[p2];
//
//                pos[p1] += sum / 10;
//                pos[p2] = (sum) % 10;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
//        return sb.length() == 0 ? "0" : sb.toString();
//    }
}
