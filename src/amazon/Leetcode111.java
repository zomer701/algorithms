package amazon;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dep = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
            }
            dep++;
        }

        return dep;
    }
}
