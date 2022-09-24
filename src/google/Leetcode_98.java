package google;

public class Leetcode_98 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(Leetcode_112.TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(Leetcode_112.TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        int value = root.val;
        if ((min != null && value <= min) || (max != null && value >= max)) {
            return false;
        }

        return isValid(root.left, min, value) && isValid(root.right, value, max);
    }
}
