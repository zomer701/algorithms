package amazon;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode366 {


    Map<Integer, List<Integer>> memo = new HashMap<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        dfs(root);

        for (Integer key : memo.keySet()) {
            result.add(memo.get(key));
        }
        return result;
    }

    private int dfs(TreeNode root) {

        if (root.left == null && root.right == null) {
            List<Integer> list = memo.getOrDefault(0, new ArrayList<>());
            list.add(root.val);
            memo.put(0, list);
            return 0;
        }

        int leftD=0;
        if (root.left != null) {
            leftD = dfs(root.left);
        }

        int rD=0;
        if (root.right != null) {
            rD = dfs(root.right);
        }
        int dept = Math.max(rD, leftD) + 1;
        List<Integer> list = memo.getOrDefault(dept, new ArrayList<>());
        list.add(root.val);
        memo.put(dept, list);
        return dept;
    }
}
