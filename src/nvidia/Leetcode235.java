package nvidia;

public class Leetcode235 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int valp = p.val;
        int valq = q.val;

        while (root != null) {
            if (root.val < valp && root.val < valq) {
                root = root.right;
                continue;
            }

            if (root.val > valp && root.val > valq) {
                root = root.left;
                continue;
            }

            return root;
        }


        return null;
    }
}

