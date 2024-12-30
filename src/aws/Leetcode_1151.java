package aws;

import java.util.Arrays;

public class Leetcode_1151 {
    public static void main(String[] args) {
        int[] data = {1,0,1,0,1};
        System.out.println(new Leetcode_1151().minSwaps(data));

        int[] data2 = {0,0,0,1,0};
        System.out.println(new Leetcode_1151().minSwaps(data2));

        int[] data3 = {1,0,1,0,1,0,0,1,1,0,1};
        System.out.println(new Leetcode_1151().minSwaps(data3));
    }

    public int minSwaps(int[] data) {
        if (data == null || data.length <= 2) {
            return 0;
        }

        int numberOneCount = 0;
        for (int i: data) {
            if (i == 1) {
                numberOneCount++;
            }
        }

        if (numberOneCount == 1 || numberOneCount == 0) {
            return 0;
        }

        int minPoint = 0;
        int swap = -1;
        for (int i = 0; i < data.length; i++) {
            if (i >= numberOneCount) {
                if (data[i] == 1) {
                    minPoint++;
                }

                if (data[i-numberOneCount] == 1) {
                    minPoint--;
                }

                if (swap > 0) {
                    swap = Math.min(swap, numberOneCount-minPoint);
                } else {
                    swap = numberOneCount-minPoint;
                }

            } else {
                if (data[i] == 1) {
                    minPoint++;
                }
            }
        }

        return swap;
    }

    public int minSwapsV2(int[] data) {
        int ones = Arrays.stream(data).sum();
        int cnt_one = 0, max_one = 0;
        int left = 0, right = 0;

        while (right < data.length) {
            cnt_one += data[right++];
            if (right - left > ones) {
                cnt_one -= data[left++];
            }
            max_one = Math.max(max_one, cnt_one);
        }
        return ones - max_one;
    }
}
