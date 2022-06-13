package elements.array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums  = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int index = 1;
        int start = 0;
        int end = nums.length-1;
        for (int i=1;i<=end;i++) {
            if (nums[start] != nums[i]) {
                nums[++start] = nums[i];
                index++;
            }
        }

        return index;
    }
}
