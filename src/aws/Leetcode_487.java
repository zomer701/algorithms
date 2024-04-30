package aws;

public class Leetcode_487 {

    public static void main(String[] args) {
        int [] data = {1,0,1,1,0,1};
        System.out.println(new Leetcode_487().findMaxConsecutiveOnes(data));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
                int temp = 1;
                int current = i;
                int start = current-1 < 0 ? -1 : current-1;
                int end = current+1 >= nums.length ? -1 : current+1;
                while ((start >= 0 && nums[start] == 1)  || (end > 0 && nums[end] == 1)) {
                    if (start >= 0) {
                        temp++;
                        start = start-1 < 0 ? -1 : start-1;
                    }

                    if (end > 0) {
                        temp++;
                        end = end+1  >= nums.length ? -1 : end+1;
                    }
                }

                count = Math.max(temp, count);
            }




        return count;
    }
}
