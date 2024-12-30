package amazon;

public class Leetcode1464 {
    public static void main(String[] args) {
    int[] data = {3,4,5,2};
    System.out.print(maxProduct(data));
    }

    public static int maxProduct(int[] nums) {
        int biggest = 0;
        int secondBiggest = 0;
        for (int num : nums) {
            if (num > biggest) {
                secondBiggest = biggest;
                biggest = num;
            } else {
                secondBiggest = Math.max(secondBiggest, num);
            }
        }

        return (biggest - 1) * (secondBiggest - 1);
    }
}
