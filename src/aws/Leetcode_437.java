package aws;

import java.util.HashMap;
import java.util.LinkedList;

public class Leetcode_437 {

        int count = 0;
        int k;
        HashMap<Integer, Integer> h = new HashMap();

    public static void main(String[] args) {
        System.out.println();
    }

    public int pathSum(TreeNode root, int targetSum) {
      k = targetSum;
      h.put(0, 1);
      preOrder(root, 0);
      return count;
    }

    private void preOrder(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum = root.val + sum;
        int need = sum - k;

        count += h.getOrDefault(need, 0);
        h.put(sum, h.getOrDefault(sum, 0) + 1);

        preOrder(root.left, sum);
        preOrder(root.right, sum);

        h.put(sum, h.get(sum) - 1);
    }
}
