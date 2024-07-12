package amazon;

import leetcode.TreeNode;

public class Leetcode100 {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }
}
