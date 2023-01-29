package aws;

public class Leetcode_226 {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        invertTreeData(root);

        return root;
    }

    private void invertTreeData(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeData(root.left);
        invertTreeData(root.right);

    }
}
