package leetcode;

import java.util.HashSet;
import java.util.Set;

public class JumpGame {
    public static void main(String[] args) {
        int[] data = {2,1,1,0,4};
        System.out.println(new JumpGame().jumpBook(data));
    }

    public boolean canJump(int[] nums) {
        int val = nums.length - 1;

        if (nums.length <= 1) {
            return true;
        }

        Set<Integer> jumpIndex = new HashSet<>();
        jumpIndex.add(0);

        for (int i = 0; i < val; i++) {
            if (jumpIndex.contains(i)) {
                int step = nums[i];
                if ((val - i) - step <= 0) {
                    return true;
                }

                int index = 0;
                while (index < step && index+i <= val) {
                    jumpIndex.add(++index + i);
                }
            }
        }

        return false;
    }

    public static boolean jumpBook(int[] nums) {
        int furthestReachSoFar = 0;
        int lastlndex = nums.length - 1;

        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastlndex; ++i) {
            furthestReachSoFar = Math.max(furthestReachSoFar , i + nums[i]);
        }
        return furthestReachSoFar >= lastlndex;
    }
}
