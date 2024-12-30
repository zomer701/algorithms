package amazon;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode637 {
    public static void main(String[] args) {

    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            long sum = 0;
            long size = queue.size();
            for (int i = 0; i< size; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add((double)sum/size);
        }


        return result;
    }
}
