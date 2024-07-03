package amazon;

import aws.TreeNode;

public class Leetcode145 {
    public static void main(String[] args) {

    }

    static void postOrderTraversal(TreeNode data) {
        postOrderTraversal(data.left);
        postOrderTraversal(data.right);
        System.out.print(data.val);
    }
}
