package google;

import aws.TreeNode;

public class Leetcode_104 {
    public int maxDepth(TreeNode root) {
        return countDepth(root, 0);
    }

    int countDepth(TreeNode root, int count) {
        if (root == null) {
            return count;
        }

        int c = count + 1;
        return Math.max(countDepth(root.left, c), countDepth(root.right, c));
    }
}
