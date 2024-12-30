package amazon;

import leetcode.TreeNode;

public class Leetcode101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        TreeNode left1L = new TreeNode(3);
        TreeNode left1R = new TreeNode(4);

        TreeNode right1L = new TreeNode(4);
        TreeNode right1R = new TreeNode(3);
//      1
//    2   2
//  3       3
//
        left1.right = left1L;
        //left1.left = left1L;
       // right1.left = right1L;
        right1.right = right1R;
        root.left = left1;
        root.right = right1;

        System.out.print(isSemantic(root));
    }

    static boolean isSemantic(TreeNode tree) {

        return helper(tree.left, tree.right);
    }

    private static boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && helper(left.left, right.right) &&  helper(left.right, right.left);
    }
}
