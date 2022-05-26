package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode ee1= new TreeNode();
        ee1.val = 20;

        TreeNode ee2= new TreeNode();
        ee2.val = 8;

        TreeNode ee= new TreeNode();
        ee.val = 3;
        ee.right =ee1;
        ee.left =ee2;


        List<List<Integer>> data = new LevelOrder().levelOrder(ee);
        int i = 0;
        for (List<Integer> val:  data) {
            System.out.println("level " + i++);
            for (Integer dd: val) {
                System.out.print(dd);

            }
            System.out.println("");
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> value2 = new ArrayList<>();

            for (int i = 0; i<qSize;i++) {
                TreeNode leaf = q.poll();
                value2.add(leaf.val);

                if (leaf.left != null) {
                    q.add(leaf.left);
                }

                if (leaf.right != null) {
                    q.add(leaf.right);
                }
            }
            result.add(value2);
        }

        return result;

    }
}
