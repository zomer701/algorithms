package nvidia;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    public static void main(String[] args) {

    }

  public class TreeNode {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> processingQ = new ArrayDeque<>();
        processingQ.add(root);


        while (!processingQ.isEmpty()) {
            int size = processingQ.size();
            List<Integer> rootList = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode current = processingQ.poll();
                rootList.add(current.val);

                if (current.left != null) {
                    processingQ.add(current.left);
                }

                if (current.right != null) {
                    processingQ.add(current.right);
                }
            }

            result.add(rootList);
        }

        return result;
    }
}
