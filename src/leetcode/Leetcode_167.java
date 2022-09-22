package leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode_167 {
    public static void main(String[] args) {
        //[-1,-1,2],[-1,0,1]

        //nums[i] + nums[j] + nums[k] == 0.

        //Notice that the solution set must not contain duplicate triplets.

        int[] data = {2,7,11,15};

         System.out.println(Arrays.toString(towSum(data, 9  )));

    }

    //O(n log(n))
    public static  int[] towSum(int[] nums, int target) {
        int[] result = new int[2];

        System.out.println(Arrays.toString(nums));

        int end = nums.length-1 ;
        int start = 0;

        while (start != end) {
            if (nums[start] + nums[end] == target) {
                result[0] = start+1;
                result[1] = end+1;
                return result;
            }

            if ((nums[start] + nums[end]) < target) {
                start++;
            } else {
                end--;
            }
        }


        return result;
    }

//    public int[] twoSum(int[] numbers, int target)
//    {
//
//
//
//
//    }

    //n^3
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (nums == null || nums.length < 2) {
//            return result;
//        }
//
//        Set<String> checkDuplicate = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i ++) {
//            for (int j = i+1; j < nums.length; j ++) {
//                for (int e = j+1; e < nums.length; e ++) {
//                    if (nums[i] + nums[j] + nums[e] == 0) {
//                        Integer[] data = new Integer[3];
//                        data[0] = nums[i];
//                        data[1] = nums[j];
//                        data[2] = nums[e];
//
//                        Arrays.sort(data);
//                        if (!checkDuplicate.contains(Arrays.toString(data))) {
//                            result.add(Arrays.asList(data));
//                        }
//                        checkDuplicate.add(Arrays.toString(data));
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
}
