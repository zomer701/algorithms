package amazon;

import aws.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode653 {

    Set<Integer> memo = new HashSet<>();
    int k;
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        return help(root);
    }

     boolean help(TreeNode root) {
        if (root == null) {
            return false;
        }


        if (memo.contains(root.val)) {
            return true;
        }

         int sum = k-root.val;
         if (sum > 0) {
             memo.add(k-root.val);
         }

        return help(root.left) || help(root.right);
    }
}
