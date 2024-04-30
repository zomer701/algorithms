package trello;

public class Leetcode_1004 {
    public static void main(String[] args) {
        int[] data = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 4;
        System.out.println(longestOnes(data, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxL = 0;
        int sezoCount = 0;


        while (right < nums.length) {
            if (nums[right] == 0) {
                sezoCount += 1;
            }

            while (sezoCount > k) {

                if (nums[left] == 0) {
                    sezoCount -= 1;
                }

                left += 1;
            }

            maxL = Math.max(maxL, right - left + 1);

            right += 1;
        }

        return maxL;
    }
}
