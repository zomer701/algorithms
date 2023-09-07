package aws;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode_1676 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode();
        node4.val = 4;

        TreeNode node7 = new TreeNode();
        node7.val = 7;

        TreeNode node2 = new TreeNode();
        node2.val = 2;
        node2.right = node4;
        node2.left = node7;

        TreeNode root6 = new TreeNode();
        root6.val = 6;

        TreeNode root5 = new TreeNode();
        root5.val = 5;
        root5.right = node2;
        root5.left = root6;

        TreeNode root0 = new TreeNode();
        root0.val = 0;

        TreeNode root8 = new TreeNode();
        root8.val = 8;

        TreeNode root1 = new TreeNode();
        root1.val = 1;
        root1.right = root8;
        root1.left = root0;

        TreeNode root3 = new TreeNode();
        root3.val = 3;
        root3.right = root1;
        root3.left = root5;



        TreeNode[] treeNodes =  new TreeNode[2];
        treeNodes[0] = node4;
        treeNodes[1] = node7;

        System.out.println(new Leetcode_1676().lowestCommonAncestor(root3, treeNodes).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> memo = new HashSet<Integer>();
        for (TreeNode node: nodes) {
            memo.add(node.val);
        }

        return bfs(root, memo);
    }

    private TreeNode bfs(TreeNode root, Set<Integer> memo) {
        if (root == null) {
            return null;
        }

        var currentValue = root.val;
        if (memo.contains(currentValue)) {
            return root;
        }

        var left = bfs(root.left, memo);
        var right = bfs(root.right, memo);

        if (left != null && right != null) {
            return root;
        }

        return left  != null ? left: right;
    }
}
