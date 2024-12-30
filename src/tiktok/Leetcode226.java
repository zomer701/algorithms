package tiktok;

import leetcode.TreeNode;

public class Leetcode226 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        revert(root);

        return root;
    }

    private void revert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;

        revert(left);
        revert(right);
    }
}
