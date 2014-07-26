package tree;

import tree.node.TreeNode;

import java.util.Stack;

/**
 * Created by liqiushi on 7/24/14.
 */
public class FlattenBinaryTreeToLinkedList {
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

        flatten(root1);
    }

    private static void flatten(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;

        while (stack.size() > 0) {
            TreeNode cur = stack.pop();

            if (cur.right != null)
                stack.push(cur.right);

            if (cur.left != null)
                stack.push(cur.left);

            if (prev != null) {
                prev.left = null;
                prev.right = cur;
            }

            prev = cur;
        }
    }
}
