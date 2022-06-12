package leetcode.binarySearch;

//704
public class BinarySearch {
    public static void main(String[] args) {

        int[] data = {-1,0,3,5,9,12};

        System.out.println(new BinarySearch().search(data, 2));
    }

    public int search(int[] nums, int target) {
        return binS(nums, 0, nums.length-1 , target);
    }


    private int binS(int[] nums, int start , int end, int target)
    {
        int resulr = -1;

        while(start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }


        }

        return resulr;
    }
}
