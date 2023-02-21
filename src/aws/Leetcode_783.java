package aws;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_783 {

    List<Integer> inorderNodes = new ArrayList<>();

    void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        // Store the nodes in the list.
        inorderNodes.add(root.val);
        inorderTraversal(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);

        int minDistance = Integer.MAX_VALUE;
        // Find the diff between every two consecutive values in the list.
        for (int i = 1; i < inorderNodes.size(); i++) {
            minDistance = Math.min(minDistance, inorderNodes.get(i) - inorderNodes.get(i-1));
        }

        return minDistance;
    }
};
