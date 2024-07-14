package amazon;

import leetcode.TreeNode;

public class Leetcode270 {
    public static void main(String[] args) {

    }

    int resul;
    public int closestValue(TreeNode root, double target) {
        resul = root.val;
        help(root, target);
        return resul;
    }

    void help(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        double value = Math.abs(target-(double)root.val);
        if (value<Math.abs(target-resul)) {
            resul = root.val;
        } else if (Math.abs(root.val - target) == Math.abs(resul - target)) {
            resul = Math.min(root.val, resul);
        }

        help(root.left, target);

        help(root.right, target);
    }
}
