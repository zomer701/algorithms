package aws;

public class Leetcode_27 {
    public static void main(String[] args) {
        int [] data = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(new Leetcode_27().removeElement(data, val));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
