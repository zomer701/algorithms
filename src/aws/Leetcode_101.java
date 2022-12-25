package aws;


public class Leetcode_101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(5);

        root.left = left;
        root.right = right;
        
        System.out.println(new Leetcode_101().isSymmetric(root));
    }

    public boolean isSymmetric (TreeNode root){
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null
                && left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left)) {
            return true;
        }

        return false;
    }
}
