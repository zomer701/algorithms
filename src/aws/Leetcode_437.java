package aws;

import java.util.HashMap;
import java.util.LinkedList;

public class Leetcode_437 {

    int count = 0;
    int k;
    HashMap<Long, Integer> h = new HashMap();

    public static void main(String[] args) {
        System.out.println();
    }

    public int pathSum(TreeNode root, int targetSum) {
      k = targetSum;
      preOrder(root, 0L);
      return count;
    }

    private void preOrder(TreeNode root, long sum) {
        if (root == null) {
            return;
        }

        long currSum = sum + root.getVal();

        if (currSum == k) {
            count++;
        }

        count += h.getOrDefault(currSum - k, 0);

        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        preOrder(root.left, currSum);
        // process right subtree
        preOrder(root.right, currSum);

        h.put(currSum, h.get(currSum) - 1);
    }
}
