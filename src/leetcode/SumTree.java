package leetcode;

public class SumTree {

    public static void main(String[] args) {
        Node root = new Node(8);

        root.left = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(-6);

        root.right = new Node(-4);
        root.right.right = new Node(9);
        root.right.left = new Node(7);

        System.out.println("Sum " + new SumTree().convertToSum(root));
    }

    public static void printNode(Node node) {
        if (node == null) {
            return;
        }

        printNode(node.left);
        System.out.println(node.value);
        printNode(node.right);
    }
    public int convertToSum(Node node) {
        if (node == null) {
            return 0;
        }

        int old = node.value;

        int leftVal = convertToSum(node.left);
        int rightVal = convertToSum(node.right);

        node.value = leftVal + rightVal;
        return node.value + old;
    }

}
