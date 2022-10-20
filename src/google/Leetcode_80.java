package google;

public class Leetcode_80 {
    public static void main(String[] args) {
        int [] data = {1,1,1,1,2,2,3};
        System.out.println(new Leetcode_80().removeDuplicates(data));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int LIMIT = 2;
        int count = 1;
        int prev = nums[0];
        int step = 1;
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];

            if (prev != value) {
                nums[step++] = value;
                count = 1;
                result++;
            } else {
                count++;
                if (count <= LIMIT) {
                    nums[step++] = nums[i];
                    result++;
                }
            }

            prev = value;
        }


        return result;
    }
}
