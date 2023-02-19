package aws;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        processing(root, result);

        return result;
    }

    private void processing(TreeNode root, List<List<Integer>> result)
    {
        if (root == null)
        {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            LinkedList<Integer> data = new LinkedList<>();
            int level = result.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (level % 2 != 0) {
                    data.addFirst(node.val);
                } else {
                    data.add(node.val);
                }


                TreeNode left = node.left;
                if (left != null)
                {
                    queue.add(left);
                }

                TreeNode right = node.right;
                if (right != null)
                {
                    queue.add(right);
                }
            }

            result.add(data);
        }
    }
}
