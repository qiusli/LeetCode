package tree;

import tree.node.TreeNode;

/**
 * Created by liqiushi on 7/24/14.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        System.out.println(isBalanced(root1));
    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return check(root) != -1;
    }

    // log the longest dist from the current node to leaf
    private static int check(TreeNode root) {
        if (root == null)
            return 0;

        int left = check(root.left);
        int right = check(root.right);

        // useful at the last compare before return back to isBalanced method
        if (left < 0 || right < 0 || Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}
