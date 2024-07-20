package amazon;

import leetcode.TreeNode;

public class Leetcode110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root)
    {
        if(root==null)
            return true;
        boolean l=isBalanced(root.left);
        boolean r=isBalanced(root.right);

        return l && r && Math.abs(height(root.left) - height(root.right)) < 2;
    }

    private int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
