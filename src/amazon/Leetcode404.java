package amazon;

import leetcode.TreeNode;

import java.util.Stack;

public class Leetcode404 {
    public static void main(String[] args) {

    }

    public static int sumOfLeftLeaves(TreeNode root) {

        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
          if (current != null) {
              stack.push(current);
              current = current.left;
              if (current != null && current.left == null && current.right ==  null) {
                  result += current.val;
              }
          } else {
              current = stack.pop();
              current = current.right;
          }
        }

        return result;
    }


}
