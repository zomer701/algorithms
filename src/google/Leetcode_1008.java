package google;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Leetcode_1008 {
    public static void main(String[] args) {
        TreeNode N_8 = new TreeNode(8);
        TreeNode N_5 = new TreeNode(5);
        TreeNode N_10 = new TreeNode(10);
        TreeNode N_1 = new TreeNode(1);
        TreeNode N_6 = new TreeNode(6);
        TreeNode N_4 = new TreeNode(4);
        TreeNode N_7 = new TreeNode(7);
        TreeNode N_12 = new TreeNode(12);

        N_8.left = N_5;
        N_8.right = N_10;

        N_5.left = N_1;
        N_5.right = N_6;

        N_10.right = N_12;

        N_6.left = N_4;
        N_6.right = N_7;

        int[] objects = new int[]{8, 5, 1, 6, 4, 7, 10, 12};
        preOrderPrint(bstFromPreorder(objects));
    }

    static void preOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

        //8
    // 5   10

//1    6       12
  // 4     7
    //8 5 1  6 4 7 10 12
    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        deque.push(root);

        int leng = preorder.length;
        for (int i = 1; i < leng; i++) {
              TreeNode node = deque.peek();
              TreeNode child = new TreeNode(preorder[i]);

              while (!deque.isEmpty() && deque.peek().val < child.val) {
                    node = deque.pop();
              }

              if (node.val < child.val) {
                  node.right = child;
              } else {
                  node.left = child;
              }
            deque.push(child);
        }

        return root;
    }
}
