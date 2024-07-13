package amazon;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144 {
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode data = stack.pop();
            result.add(data.val);

            if (data.left != null) {
                stack.add(data.left);
            }


            if (data.right != null) {
                stack.add(data.right);
            }
        }

        return result;
    }
}
