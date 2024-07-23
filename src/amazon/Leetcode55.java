package amazon;

import google.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int le = nums.length-1;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(0, nums[0]));

        if (!queue.isEmpty()) {
            Pair currenJump = queue.poll();
            if ((int)currenJump.getFirst() == le) {
                return true;
            }

            if ((int)currenJump.getFirst() < le) {
                for (int i = (int)currenJump.getFirst(); i <= Math.min(i+ (int)currenJump.getSecond(), nums.length-1); i++) {
                    queue.add(new Pair(i, nums[i]));
                }
            }
        }
        return false;
    }
}
