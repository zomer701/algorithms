package elements.array;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] data = {1,0,2};
        new SortColors().sortColorsLiner(data);
        System.out.println(Arrays.toString(data));
    }

    public void sortColorsLiner(int[] nums) {
        int start = 0;
        int current =  0;
        int end = nums.length-1;

        while (current <= end) {
            if (nums[current] == 0) {
                    swap(nums, current++, start++);
                continue;
            }

            if (nums[current] == 2) {
                    swap(nums, current, end--);
                continue;
            }

            ++current;
        }
    }

    public void sortColors(int[] nums) {
        int start =  0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, start++);
            }
        }

        int end = nums.length - 1;
        for (int i = nums.length-1; i >= 0 && i >= start; i--) {
            if (nums[i] == 2) {
                swap(nums, i, end--);
            }
        }

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
