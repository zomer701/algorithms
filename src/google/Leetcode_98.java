package google;


import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_98 {
    Deque<Leetcode_112.TreeNode> nodeDeque = new LinkedList<>();
    Deque<Pair<Integer, Integer>> minMax = new LinkedList<>();


    public static void main(String[] args) {

    }

    public boolean isValidBST(Leetcode_112.TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(Leetcode_112.TreeNode root) {
        if (root == null) {
            return false;
        }

        nodeDeque.push(root);
        minMax.push(new Pair<>(null, null));

        while (!nodeDeque.isEmpty()) {
            Leetcode_112.TreeNode current = nodeDeque.pop();
            Pair<Integer, Integer> currentMinMax = minMax.pop();
            Integer min = currentMinMax.getFirst();
            Integer max = currentMinMax.getSecond();

            int value = current.val;
            if ((min != null && value <= min) || (max != null && value >= max)) {
                return false;
            }

            Leetcode_112.TreeNode left = current.left;
            if (left != null) {
                nodeDeque.push(left);
                minMax.push(new Pair<>(min, value));
            }

            Leetcode_112.TreeNode right = current.right;
            if (right != null) {
                nodeDeque.push(right);
                minMax.push(new Pair<>(value, max));
            }
        }

        return true;
    }

    private boolean isValid(Leetcode_112.TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        int value = root.val;
        if ((min != null && value <= min) || (max != null && value >= max)) {
            return false;
        }

        return isValid(root.left, min, value) && isValid(root.right, value, max);
    }
}
