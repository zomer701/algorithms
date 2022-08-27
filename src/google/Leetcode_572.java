package google;

public class Leetcode_572 {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        if (isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot) ) {
            return true;
        }

        return false;
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root== null || subRoot==null) {
            return   root==null && subRoot==null;
        }

        if (root.val == subRoot.val) {
            return isSameTree(root.right, subRoot.right) && isSameTree(root.left, subRoot.left);
        }

        return false;
    }

    private class TreeNode {
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
}
