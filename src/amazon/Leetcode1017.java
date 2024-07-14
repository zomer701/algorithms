package amazon;

public class Leetcode1017 {
    public static void main(String[] args) {
        System.out.print(baseNeg2(2));
    }

    public static String baseNeg2(int n) {
        StringBuilder sc = new StringBuilder();
        int rem;
        int b = -2;
        if(n == 0) sc.append('0');

        while(n != 0) {
            rem = n % b;
            n /= b;
            if(rem < 0){
                rem -= b;
                n++;
            }
            sc.append(rem);
        }
        return sc.reverse().toString();
    }
}
