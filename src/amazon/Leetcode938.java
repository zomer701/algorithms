package amazon;

import leetcode.TreeNode;

public class Leetcode938 {
    static int sum = 0;

    public static void main(String[] args) {

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        help(root, low, high);
       return sum;
    }

    static void help(TreeNode root, int low, int high) {
        if (root == null) {
          return;
        }

        if (low <= root.val && root.val <= high) {
            sum+=root.val;
        }

        if (low < root.val)
            help(root.left, low, high);
        if (root.val < high)
            help(root.right, low, high);
    }
}
