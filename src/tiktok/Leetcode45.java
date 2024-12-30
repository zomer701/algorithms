package tiktok;

public class Leetcode45 {

    public static void main(String[] args) {
        System.out.println(new Leetcode45().jump(new int []{2,3,1,1,4}));
    }

    // [2,3,1,1,4,1,1,1,5]
    public  int jump(int[] nums) {
            if (nums == null || nums.length == 1) {
                return 0;
            }

        int answer = 1;
        int jumpLevel = 0;
        int jumpLevelValue = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int jump = nums[i];

            int distance = i+jump;
            jumpLevelValue = Math.max(jumpLevelValue, distance);
            if (distance >= nums.length-1) {
                return answer;
            }

            if (jumpLevel == i) {
                jumpLevel = jumpLevelValue;
                answer++;
            }

        }

        return answer;
    }
}
