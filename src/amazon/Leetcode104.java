package amazon;

import leetcode.TreeNode;

public class Leetcode104 {
    public static void main(String[] args) {

    }

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
