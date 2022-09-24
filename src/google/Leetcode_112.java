package google;

public class Leetcode_112 {

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

    public static void main(String[] args) {

    }

    public boolean sum(TreeNode root, int sum, int current) {

        if (root == null)
            return false;

        if(current + root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        if (sum(root.right, sum, current + root.val))
            return true;

        if (sum(root.left, sum, current + root.val))
            return true;

        return false;

    }
}
