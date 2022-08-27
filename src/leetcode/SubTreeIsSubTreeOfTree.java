package leetcode;

import google.Leetcode_572;

import java.util.ArrayList;
import java.util.List;

public class SubTreeIsSubTreeOfTree {
    public static void main(String[] args) {
        System.out.println(new SubTreeIsSubTreeOfTree().isSubtree(new TreeNode(0), new TreeNode(1)));
    }

    public boolean isSubtree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null) {
            return false;
        }

        if (treeNode2 == null) {
            return true;
        }

        List<Integer> value = new ArrayList<>();
        List<Integer> value2 = new ArrayList<>();

        innerOrder(treeNode1, value);
        innerOrder(treeNode2, value2);

        if (!value.toString().replace("[", "").replace("]", "").replace(",", "").contains(value2.toString().replace("[", "").replace("]", "").replace(",", ""))) {
            return false;
        }

        value.clear();;
        value2.clear();;

        preOrder(treeNode1, value);
        preOrder(treeNode2, value2);

        return value.toString().replace("[", "").replace("]", "").replace(",", "").contains(value2.toString().replace("[", "").replace("]", "").replace(",", ""));

    }

    void preOrder(TreeNode treeNode1, List<Integer> value) {
        if (treeNode1 == null) {
            return;
        }

        value.add(treeNode1.val);
        innerOrder(treeNode1.left, value);
        innerOrder(treeNode1.right, value);
    }

    void innerOrder(TreeNode treeNode1, List<Integer> value) {
        if (treeNode1 == null) {
            return;
        }

        innerOrder(treeNode1.left, value);
        value.add(treeNode1.val);
        innerOrder(treeNode1.right, value);

    }

    private static class TreeNode {
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
}
