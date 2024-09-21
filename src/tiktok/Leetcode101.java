package tiktok;

import aws.TreeNode;

public class Leetcode101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric (TreeNode root){
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null &&  right == null) {
            return true;
        }

        if (left != null && right == null) {
            return false;
        }

        if (left == null && right != null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
