package aws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode_230 {
    List<Integer> memo = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {

        preorder(root);
        if (memo.size() < k) {
            return -1;
        }

        Collections.sort(memo);
        return memo.get(k);
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        memo.add(root.val);

        preorder(root.left);
        preorder(root.right);
    }

//    static int count;
//    static int res;
//    public int kthSmallest(TreeNode root, int k) {
//        count = 0;
//        res = 0;
//        inorder(root,k);
//        return res;
//    }
//    private void inorder(TreeNode root, int k){
//        if(root == null)
//            return;
//
//        inorder(root.left,k);
//        count++;
//        if(count == k){
//            res = root.val;
//            return;
//        }
//        inorder(root.right,k);
//    }
}
