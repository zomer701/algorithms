package leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode_15 {
    public static void main(String[] args) {
        //[-1,-1,2],[-1,0,1]

        //nums[i] + nums[j] + nums[k] == 0.

        //Notice that the solution set must not contain duplicate triplets.

        int[] data = {-1,0,1,2,-1,-4};

        for (List<Integer> val: threeSum(data)) {
            String result = val.stream().
                    map(String::valueOf).
                    collect(Collectors.joining("/", "(", ")"));

            System.out.println(result);
        }
    }

    //O(n log(n))
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        //-4, -1, -1, 0, 1, 2
        Arrays.sort(nums);


        int end = nums.length-1 ;
        int start = 0;
        int mid = 1;

        Set<String> checkDuplicate = new HashSet<>();

       while (start < end) {
            if (mid == end) {
                start++;
                mid = start + 1;
                end = nums.length-1;
                if (mid >= end) {
                    return result;
                }
            }

            int sum = nums[start] + nums[mid] + nums[end];

            if (nums[start] + nums[mid] + nums[end] == 0) {
                Integer[] dataArray = {nums[start], nums[mid], nums[end]};

                String key = Arrays.toString(dataArray);
                if (!checkDuplicate.contains(key)) {
                    List<Integer> data = List.of(dataArray);
                    result.add(data);
                    checkDuplicate.add(key);
                }

                mid++;
            } else {
                if (sum < 0) {
                    mid++;
                } else {
                    end--;
                }
            }
        }

        return result;
    }

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

//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
//            if (i == 0 || nums[i - 1] != nums[i]) {
//                twoSumII(nums, i, res);
//            }
//        return res;
//    }
//    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
//        int lo = i + 1, hi = nums.length - 1;
//        while (lo < hi) {
//            int sum = nums[i] + nums[lo] + nums[hi];
//            if (sum < 0) {
//                ++lo;
//            } else if (sum > 0) {
//                --hi;
//            } else {
//                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
//                while (lo < hi && nums[lo] == nums[lo - 1])
//                    ++lo;
//            }
//        }
//    }
}
