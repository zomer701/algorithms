package apple;

public class Leetcode110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
