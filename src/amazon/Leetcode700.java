package amazon;

import leetcode.TreeNode;

public class Leetcode700 {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
         if (root.val == val) {
             return root;
         }

         if (root.val > val) {
             if (root.left != null) {
                 return searchBST(root.left, val);
             }
         } else {
             if (root.right != null) {
                 return searchBST(root.right, val);
             }
         }
        return null;
    }

}
