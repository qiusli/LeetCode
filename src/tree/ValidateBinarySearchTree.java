package tree;

import tree.node.TreeNode;

/**
 * Created by liqiushi on 7/31/14.
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node3.right = node4;

        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return inorderTraverse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean inorderTraverse(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return inorderTraverse(root.left, min, root.val) && inorderTraverse(root.right, root.val, max);
    }
}
