package aws;

public class Leetcode_33 {
    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
    }



//    public int search(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
    public static int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int mid=start+(end-start)/2;
        for(int i=0,j=end;i<mid||j>=mid;i++,j--)
        {
            if(nums[i]==target) return i;
            if(nums[j]==target) return j;
        }
        return -1;
    }
}
